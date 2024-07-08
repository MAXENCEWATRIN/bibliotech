package com.maxencew.biblioto.application.service.adapter;

import com.maxencew.biblioto.application.mapper.BookEntityMapper;
import com.maxencew.biblioto.application.service.api.BookService;
import com.maxencew.biblioto.domain.model.Book;
import com.maxencew.biblioto.domain.ports.spi.BookPersistencePort;
import com.maxencew.biblioto.infrastructure.repository.BookRepository;
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

    private final BookPersistencePort bookPersistencePort;
    private final IsbnApiService isbnApiService;

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
            return isbnApiService.findBookByIsbnIdOnExternalResources(isbnId);
        }

        return bookRetrieveByIsbnId;
    }


}
