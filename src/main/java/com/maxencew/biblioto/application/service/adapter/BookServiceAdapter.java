package com.maxencew.biblioto.application.service.adapter;

import com.maxencew.biblioto.application.response.isbn.BookIsbnResponse;
import com.maxencew.biblioto.application.service.IsbnService;
import com.maxencew.biblioto.application.service.api.BookService;
import com.maxencew.biblioto.domain.model.Book;
import com.maxencew.biblioto.domain.ports.spi.BookPersistencePort;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@Slf4j
@AllArgsConstructor
public class BookServiceAdapter implements BookService {

    @Autowired
    private final BookPersistencePort bookPersistencePort;
    @Autowired
    private final IsbnService isbnService;

    public Book addBook(Book book) {
        return this.bookPersistencePort.addBook(book);
    }

    public void removeBook(Book book) {
        this.bookPersistencePort.removeBook(book);
    }

    public List<Book> getBooks() {
        return this.bookPersistencePort.getBooks();
    }

    public Book getBookById(Long id) {
        return this.bookPersistencePort.getBookById(id);
    }

    public Book getByIsbnId(Long isbnId) {
        final var bookRetrieveByIsbnId = this.bookPersistencePort.getBookByIsbnId(isbnId);

        if (Objects.isNull(bookRetrieveByIsbnId)) {
            LOGGER.info("The Isbn id {} didn't exist yet, trying to retrieve information on external API.", isbnId);
            return isbnService.findBookByIsbnIdOnExternalResources(isbnId);
        }

        return bookRetrieveByIsbnId;
    }


}
