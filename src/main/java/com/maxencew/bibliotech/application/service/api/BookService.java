package com.maxencew.bibliotech.application.service.api;

import com.maxencew.bibliotech.domain.model.Book;

import java.util.List;

public interface BookService {

    Book addBook(Book book);

    void removeBook(Book book);

    List<Book> getBooks();

    Book getBookById(Long bookId);
    Book getByIsbnId(Long bookId);
}
