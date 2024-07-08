package com.maxencew.biblioto.application.mapper;

import com.maxencew.biblioto.domain.model.Book;
import com.maxencew.biblioto.infrastructure.entity.BookEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-08T18:30:18+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class BookEntityMapperImpl implements BookEntityMapper {

    @Override
    public BookEntity toEntity(Book book) {
        if ( book == null ) {
            return null;
        }

        BookEntity.BookEntityBuilder bookEntity = BookEntity.builder();

        return bookEntity.build();
    }

    @Override
    public Book toDomain(BookEntity bookEntity) {
        if ( bookEntity == null ) {
            return null;
        }

        Book.BookBuilder book = Book.builder();

        return book.build();
    }

    @Override
    public List<Book> toDomainList(List<BookEntity> entities) {
        if ( entities == null ) {
            return null;
        }

        List<Book> list = new ArrayList<Book>( entities.size() );
        for ( BookEntity bookEntity : entities ) {
            list.add( toDomain( bookEntity ) );
        }

        return list;
    }

    @Override
    public List<BookEntity> toEntityList(List<Book> books) {
        if ( books == null ) {
            return null;
        }

        List<BookEntity> list = new ArrayList<BookEntity>( books.size() );
        for ( Book book : books ) {
            list.add( toEntity( book ) );
        }

        return list;
    }
}
