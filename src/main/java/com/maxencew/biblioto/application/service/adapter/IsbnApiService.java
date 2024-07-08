package com.maxencew.biblioto.application.service.adapter;

import com.maxencew.biblioto.application.response.isbn.BookIsbnResponse;
import com.maxencew.biblioto.domain.model.Book;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Objects;

@Service
@AllArgsConstructor
@Slf4j
public class IsbnApiService {
    private static final String ISBN_API_BOOK_URL = "https://api2.isbndb.com/book/{id}";
    @Autowired
    private final RestTemplate restTemplate;


    public Book findBookByIsbnIdOnExternalResources(Long isbnId) {
        //Ici dévlopper l'appel vers l'API externe
        final var bookRetrieveByIsbnId = this.bookRepository.getBookByIsbnId(isbnId);

        if (Objects.isNull(bookRetrieveByIsbnId)) {
            LOGGER.info("Information from ISBN api will be retrieve for the id", isbnId);
            String url = UriComponentsBuilder.fromUriString(ISBN_API_BOOK_URL)
                    .buildAndExpand(isbnId)
                    .toUriString();
            final var livreIsbn = restTemplate.getForObject(url, BookIsbnResponse.class);
            return Book.builder()
                    .withIsbnId(Integer.valueOf(livreIsbn.getIsbn()))
                    .build();
        }

        return bookEntityMapper.toDomain(bookRetrieveByIsbnId);
    }
}
