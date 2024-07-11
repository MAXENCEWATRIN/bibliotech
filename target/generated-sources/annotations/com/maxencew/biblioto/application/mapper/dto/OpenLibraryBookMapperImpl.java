package com.maxencew.biblioto.application.mapper.dto;

import com.maxencew.biblioto.application.exception.MappingException;
import com.maxencew.biblioto.domain.model.Book;
import com.maxencew.biblioto.infrastructure.external.OpenLibraryBookApiResponse;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-11T15:43:07+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class OpenLibraryBookMapperImpl implements OpenLibraryBookMapper {

    @Override
    public Book toDomain(OpenLibraryBookApiResponse bookOpenLibrary) throws MappingException {
        if ( bookOpenLibrary == null ) {
            return null;
        }

        Book.BookBuilder book = Book.builder();

        return book.build();
    }
}
