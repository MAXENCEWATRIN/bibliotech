package com.maxencew.biblioto.application.mapper;

import com.maxencew.biblioto.application.request.BookRequest;
import com.maxencew.biblioto.application.response.BookResponse;
import com.maxencew.biblioto.domain.model.Book;
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
public class BookDtoMapperImpl implements BookDtoMapper {

    @Override
    public Book toDomain(BookRequest request) {
        if ( request == null ) {
            return null;
        }

        Book.BookBuilder book = Book.builder();

        return book.build();
    }

    @Override
    public BookResponse toDto(Book book) {
        if ( book == null ) {
            return null;
        }

        BookResponse.BookResponseBuilder bookResponse = BookResponse.builder();

        return bookResponse.build();
    }

    @Override
    public List<Book> toDomainList(List<BookRequest> booksRequested) {
        if ( booksRequested == null ) {
            return null;
        }

        List<Book> list = new ArrayList<Book>( booksRequested.size() );
        for ( BookRequest bookRequest : booksRequested ) {
            list.add( toDomain( bookRequest ) );
        }

        return list;
    }

    @Override
    public List<BookResponse> toDtoList(List<Book> books) {
        if ( books == null ) {
            return null;
        }

        List<BookResponse> list = new ArrayList<BookResponse>( books.size() );
        for ( Book book : books ) {
            list.add( toDto( book ) );
        }

        return list;
    }
}
