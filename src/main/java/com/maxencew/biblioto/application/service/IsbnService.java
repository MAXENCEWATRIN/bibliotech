package com.maxencew.biblioto.application.service;

import com.maxencew.biblioto.domain.model.Book;
import com.maxencew.biblioto.domain.ports.spi.BookPersistencePort;
import com.maxencew.biblioto.domain.ports.spi.ExternalIsbnApiPort;
import com.maxencew.biblioto.domain.ports.spi.OpenLibraryApiPort;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class IsbnService {


    @Autowired
    private final BookPersistencePort bookPersistencePort;
    @Autowired
    private final OpenLibraryApiPort openLibraryApiPort;

    public Book findBookByIsbnIdOnExternalResources(Long isbnId) {
        final var bookRetrieveByIsbnId = this.bookPersistencePort.getBookByIsbnId(isbnId);
        if (Objects.isNull(bookRetrieveByIsbnId)) {
            LOGGER.info("Information from ISBN api will be retrieve for the id {}", isbnId);

            final Optional<Book> book = openLibraryApiPort.retrieveBookInformation(isbnId);
            if (book.isEmpty()) {
                throw new IllegalArgumentException("Aucune info sur ce livre dans l'API openLibrary.");
            }
            return book.get();
        }
        return bookRetrieveByIsbnId;
    }
}
