package com.maxencew.bibliotech.domain.service.adapter;

import com.maxencew.bibliotech.domain.model.Book;
import com.maxencew.bibliotech.domain.ports.spi.BookPersistencePort;
import com.maxencew.bibliotech.domain.ports.spi.OpenLibraryApiPort;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;
import java.util.Optional;

@Slf4j
@AllArgsConstructor
public class IsbnService {

    private final BookPersistencePort bookPersistencePort;
    private final OpenLibraryApiPort openLibraryApiPort;

    public Book findBookByIsbnIdOnExternalResources(Long isbnId) {
        final var bookRetrieveByIsbnId = this.bookPersistencePort.getBookByIsbnId(isbnId);
        if (Objects.isNull(bookRetrieveByIsbnId)) {
            LOGGER.info("Information from ISBN api will be retrieve for the id {}", isbnId);

            final Optional<Book> book = openLibraryApiPort.retrieveBookInformation(isbnId);
            if (book.isEmpty()) {
                throw new IllegalArgumentException("Aucune info sur ce livre dans l'API openLibrary.");
            }

            Book buildBook = book.get();
            LOGGER.info("{}, {}, {}, {}", buildBook.getAuthorName(), buildBook.getTitle(), buildBook.getIsbnId(), buildBook.getNumberOfPage());
            return buildBook;
        }
        return bookRetrieveByIsbnId;
    }
}
