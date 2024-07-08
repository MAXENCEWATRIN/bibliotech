package com.maxencew.biblioto.domain.ports.api;

import com.maxencew.biblioto.domain.model.Book;

import java.sql.SQLException;
import java.util.List;

public interface BookServicePort {

    Book add(Book book) throws SQLException, NoSuchMethodException;

    void delete(String id) throws SQLException, NoSuchMethodException;

    Book update(Book book, String id) throws SQLException, NoSuchMethodException;

    List<Book> getAll() throws SQLException, NoSuchMethodException;

    Book getById(String id) throws SQLException, NoSuchMethodException;
}
