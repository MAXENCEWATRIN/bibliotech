package com.maxencew.bibliotech.infrastructure.adapter;

import com.maxencew.bibliotech.application.mapper.dto.OpenLibraryBookMapper;
import com.maxencew.bibliotech.domain.model.Book;
import com.maxencew.bibliotech.domain.model.Editor;
import com.maxencew.bibliotech.domain.ports.spi.OpenLibraryApiPort;
import com.maxencew.bibliotech.infrastructure.exception.ExternalRessourcesCommunicationException;
import com.maxencew.bibliotech.infrastructure.external.OpenLibraryBookApiResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.*;

@Component
@AllArgsConstructor
@Slf4j
public class OpenLibraryApiAdapter implements OpenLibraryApiPort {
    private static final String ISBN_QUERY = "isbn/";
    private static final String JSON_SUFFIX = ".json";
    private static final String FIELDS_QUERY = "&fields=key,title,author_name,editions";
    private final RestTemplate restTemplate;
    @Autowired
    private final Environment environment;
    private final OpenLibraryBookMapper openLibraryBookMapper;

    public String buildOpenLibraryApiBookUrl(Long isbnId) {
        return environment.getProperty("external.api.openLibrary.books-api.url") + ISBN_QUERY + isbnId + JSON_SUFFIX;
    }

    @Override
    public String requestAccessToken() {
        try {
            String url = "https://openlibrary.org/account/login";

            HttpHeaders headers = new HttpHeaders();
            headers.set("Content-Type", "application/json");

            Map<String, String> requestBody = Map.of(
                    "access", environment.getProperty("external.api.openLibrary.login"),
                    "secret", environment.getProperty("external.api.openLibrary.key")
            );

            HttpEntity<Map<String, String>> requestEntity = new HttpEntity<>(requestBody, headers);

            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);

            if (response.getStatusCode() == HttpStatus.OK) {
                HttpHeaders responseHeaders = response.getHeaders();
                String setCookie = responseHeaders.getFirst(HttpHeaders.SET_COOKIE);
                if (Objects.nonNull(setCookie)) {
                    return setCookie;
                }
            }
        } catch (Exception e) {
            throw new ExternalRessourcesCommunicationException(String.format("OpenLibary API doesn't respond correctly right now. %s", e.getMessage()));
        }
        throw new ExternalRessourcesCommunicationException("OpenLibary API doesn't respond correctly right now.");
    }

    @Override
    public Optional<Book> retrieveBookInformation(Long isbnId) {
        final var sessionId = requestAccessToken();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Cookie", sessionId);

        HttpEntity<Void> requestEntity = new HttpEntity<>(headers);

        String url = buildOpenLibraryApiBookUrl(isbnId);
        try {
            ResponseEntity<OpenLibraryBookApiResponse> response = restTemplate.exchange(url, HttpMethod.GET, requestEntity, OpenLibraryBookApiResponse.class);
            LOGGER.info("{} - Api Call to Open Library API result.", response.getStatusCode());
            if (HttpStatus.OK.equals(response.getStatusCode())) {
                List<Book> booksOpenLibraryResponse = new ArrayList<>();

                if (Objects.isNull(response.getBody())) {
                    return Optional.empty();
                }
                response.getBody().getRecords().forEach((_, openLibaryBookResponse) -> {
                    OpenLibraryBookApiResponse.DetailsData detailsData = openLibaryBookResponse.getDetails().getDetailsData();

                    Optional<OpenLibraryBookApiResponse.Excerpt> excerpt = Optional.ofNullable(openLibaryBookResponse.getData())
                            .map(OpenLibraryBookApiResponse.Data::getExcerpts)
                            .flatMap(excerpts -> excerpts.stream()
                                    .filter(OpenLibraryBookApiResponse.Excerpt::isFirstSentence)
                                    .findFirst());

                    Editor editor = null;
                    if(Objects.nonNull(detailsData.getPublishers())) {
                        editor = Editor.builder()
                                .name(detailsData.getPublishers().getFirst())
                                .build();
                    }

                    List<OpenLibraryBookApiResponse.Item> items = response.getBody().getItems();
                    Optional<List<String>> isbn10 = Optional.ofNullable(detailsData.getIsbn10());
                    booksOpenLibraryResponse.add(Book.builder()
                            .isbnId(new BigDecimal(detailsData.getIsbn13().getFirst()))
                            .oldIsbnId(removeNonNumericCharacters(isbn10.map(List::getFirst).orElse(null)))
                            .openLibraryId(openLibaryBookResponse.getOlids().getFirst())
                            .titleLong(detailsData.getFullTitle())
                            .title(detailsData.getTitle())
                            .numberOfPage(detailsData.getNumberOfPages())
                            .firstSentence(excerpt.map(OpenLibraryBookApiResponse.Excerpt::getText).orElse(null))
                            .editor(editor)
                            .isAnOpenLibaryApiRegister(true)
                            .isAnOpenLibaryApiBookValidate(false)
                            .isWishList(false)
                            .coverPageUrl(items.isEmpty() ? null : items.getFirst().getCover().getLarge())
                            .build());
                });

                return Optional.of(booksOpenLibraryResponse.getFirst());

            }
        } catch (Exception e) {
            throw new ExternalRessourcesCommunicationException(String.format("OpenLibary API doesn't respond correctly right now. %s", e.getMessage()));
        }
        throw new ExternalRessourcesCommunicationException("Api call error.");

    }


    @Override
    //A terminer
    public Optional<Book> retrieveBookCover(Long isbnId) {
        String url = String.format("%s/books/%s", environment.getProperty("external.api.openLibrary.covers-api.url"), isbnId);
        ResponseEntity<Book> response = restTemplate.getForEntity(url, Book.class);
        LOGGER.info("{} - Api Call to Open Library API result.", response.getStatusCode());

        if (HttpStatus.OK.equals(response.getStatusCode())) {
            OpenLibraryBookApiResponse bookOpenLibrary = restTemplate.getForObject(url, OpenLibraryBookApiResponse.class);
            return Optional.ofNullable(bookOpenLibrary)
                    .map(openLibraryBookMapper::toDomain);
        }
        throw new IllegalArgumentException("Api call error.");

    }

    public static BigDecimal removeNonNumericCharacters(String input) {
        return Objects.nonNull(input) ? new BigDecimal(input.replaceAll("[^0-9]", "")) : null;
    }
}
