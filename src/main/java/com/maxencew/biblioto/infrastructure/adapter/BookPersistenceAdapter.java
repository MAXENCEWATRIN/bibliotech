package com.maxencew.biblioto.infrastructure.adapter;

import com.maxencew.biblioto.application.mapper.entity.BookEntityMapper;
import com.maxencew.biblioto.domain.model.Book;
import com.maxencew.biblioto.domain.ports.spi.BookPersistencePort;
import com.maxencew.biblioto.infrastructure.entity.BookEntity;
import com.maxencew.biblioto.infrastructure.exception.AppPersistenceException;
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
        BookEntity bookEntity = bookEntityMapper.toEntity(book);
        BookEntity bookPersisted;
        try {
            bookPersisted = bookRepository.save(bookEntity);
        } catch (Exception e) {
            throw new AppPersistenceException(e.getMessage(), e);
        }
        return bookEntityMapper.toDomain(bookPersisted);
    }

    @Override
    public void removeBook(Book book) {
        BookEntity bookEntity = bookEntityMapper.toEntity(book);
        try {
            bookRepository.delete(bookEntity);
        } catch (Exception e) {
            throw new AppPersistenceException(e.getMessage(), e);
        }
    }

    @Override
    public List<Book> getBooks() {
        List<BookEntity> books;
        try {
            books = bookRepository.findAll();
        } catch (Exception e) {
            throw new AppPersistenceException(e.getMessage(), e);
        }
        return bookEntityMapper.toDomainList(books);

    }

    @Override
    public Book getBookById(Long bookId) {
        BookEntity referenceById;
        try {
            referenceById = this.bookRepository.getReferenceById(bookId);
        } catch (Exception e) {
            throw new AppPersistenceException(e.getMessage(), e);
        }

        return bookEntityMapper.toDomain(referenceById);

    }

    @Override
    public Book getBookByIsbnId(Long isbnBookId) {
        BookEntity bookByIsbnId;
        try {
            bookByIsbnId = this.bookRepository.getBookByIsbnId(isbnBookId);
        } catch (Exception e) {
            throw new AppPersistenceException(e.getMessage(), e);
        }

        return bookEntityMapper.toDomain(bookByIsbnId);
    }

}
