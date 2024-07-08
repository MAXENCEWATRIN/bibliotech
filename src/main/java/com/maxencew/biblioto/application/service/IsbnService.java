package com.maxencew.biblioto.application.service;

import com.maxencew.biblioto.application.response.isbn.BookIsbnResponse;
import com.maxencew.biblioto.domain.model.Book;
import com.maxencew.biblioto.domain.ports.spi.BookPersistencePort;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Objects;

@Slf4j
@Service
@AllArgsConstructor
public class IsbnService {
    private static final String ISBN_API_BOOK_URL = "https://api2.isbndb.com/book/{id}";
    @Autowired
    private final RestTemplate restTemplate;

    @Autowired
    private final BookPersistencePort bookPersistencePort;

    public Book findBookByIsbnIdOnExternalResources(Long isbnId) {
        //Ici dévlopper l'appel vers l'API externe
        final var bookRetrieveByIsbnId = this.bookPersistencePort.getBookByIsbnId(isbnId);
        if (Objects.isNull(bookRetrieveByIsbnId)) {
            LOGGER.info("Information from ISBN api will be retrieve for the id {}", isbnId);
            String url = UriComponentsBuilder.fromUriString(ISBN_API_BOOK_URL)
                    .buildAndExpand(isbnId)
                    .toUriString();
            final var livreIsbn = restTemplate.getForObject(url, BookIsbnResponse.class);
            return Book.builder()
                    .isbnId(Integer.valueOf(livreIsbn.getIsbn()))
                    .build();
        }
        return bookRetrieveByIsbnId;
    }
}
