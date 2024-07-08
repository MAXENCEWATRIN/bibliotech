package com.maxencew.biblioto.application.mapper;

import com.maxencew.biblioto.application.request.BookRequest;
import com.maxencew.biblioto.application.response.BookResponse;
import com.maxencew.biblioto.domain.model.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookDtoMapper {

    @Mapping(target = "withId", ignore = true)
    Book toDomain(BookRequest request);

    BookResponse toDto(Book book);

    List<Book> toDomainList(List<BookRequest> booksRequested);

    List<BookResponse> toDtoList(List<Book> books);


}
