package com.maxencew.bibliotech.domain.ports.spi;

import com.maxencew.bibliotech.domain.model.Book;

import java.util.List;

public interface BookPersistencePort {

    Book addBook(Book book);

    void removeBook(Book book);

    List<Book> getBooks();

    Book getBookById(Long bookId);

    Book getBookByIsbnId(Long isbnBookId);
}
