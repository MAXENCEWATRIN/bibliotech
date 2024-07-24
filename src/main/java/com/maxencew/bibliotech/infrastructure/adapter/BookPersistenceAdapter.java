package com.maxencew.bibliotech.infrastructure.adapter;

import com.maxencew.bibliotech.domain.model.Book;
import com.maxencew.bibliotech.domain.ports.spi.BookPersistencePort;
import com.maxencew.bibliotech.infrastructure.entity.BookEntity;
import com.maxencew.bibliotech.infrastructure.exception.AppPersistenceException;
import com.maxencew.bibliotech.infrastructure.mapper.entity.BookEntityMapper;
import com.maxencew.bibliotech.infrastructure.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class BookPersistenceAdapter implements BookPersistencePort {

    private final BookRepository bookRepository;
    private final BookEntityMapper bookEntityMapper;

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
