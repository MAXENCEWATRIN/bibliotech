package com.maxencew.biblioto.infrastructure.adapter;

import com.maxencew.biblioto.application.mapper.BookEntityMapper;
import com.maxencew.biblioto.domain.model.Book;
import com.maxencew.biblioto.domain.ports.spi.BookPersistencePort;
import com.maxencew.biblioto.infrastructure.repository.BookRepository;

import java.util.List;

public class BookAdapter implements BookPersistencePort {

    private BookRepository bookRepository;
    private BookEntityMapper bookEntityMapper;

    @Override
    public Book addBook(Book book) {
       return  bookEntityMapper.toDomain(bookRepository.save(bookEntityMapper.toEntity(book)));
    }

    @Override
    public void removeBook(Book book) {
        bookRepository.delete(bookEntityMapper.toEntity(book));
    }

    @Override
    public List<Book> getBooks() {
       return bookEntityMapper.toDomainList(bookRepository.findAll());
    }

    @Override
    public Book getBookById(Long bookId) {
        return bookEntityMapper.toDomain(this.bookRepository.getReferenceById(bookId));
    }

    @Override
    public Book getBookByIsbnId(Long isbnBookId) {
        return bookEntityMapper.toDomain(this.bookRepository.getBookByIsbnId(isbnBookId));
    }

}
