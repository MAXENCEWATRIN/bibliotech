package com.maxencew.biblioto.application.service.api;

import com.maxencew.biblioto.domain.model.Book;

import java.util.List;

public interface BookService {

    Book addBook(Book book);

    void removeBook(Book book);

    List<Book> getBooks();

    Book getBookById(Long bookId);
    Book getByIsbnId(Long bookId);
}
