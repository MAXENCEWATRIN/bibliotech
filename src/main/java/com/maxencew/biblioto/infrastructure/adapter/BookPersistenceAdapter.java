package com.maxencew.biblioto.infrastructure.adapter;

import com.maxencew.biblioto.application.mapper.entity.BookEntityMapper;
import com.maxencew.biblioto.domain.model.Book;
import com.maxencew.biblioto.domain.ports.spi.BookPersistencePort;
import com.maxencew.biblioto.infrastructure.repository.BookRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookPersistenceAdapter implements BookPersistencePort {

    private final BookRepository bookRepository;
    private final BookEntityMapper bookEntityMapper;

    public BookPersistenceAdapter(BookRepository bookRepository, BookEntityMapper bookEntityMapper) {
        this.bookRepository = bookRepository;
        this.bookEntityMapper = bookEntityMapper;
    }

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
