package com.maxencew.bibliotech.application.mapper.dto;

import com.maxencew.bibliotech.application.exception.MappingDtoException;
import com.maxencew.bibliotech.application.request.BookRequest;
import com.maxencew.bibliotech.application.response.BookResponse;
import com.maxencew.bibliotech.domain.model.Book;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookDtoMapper {

    Book toDomain(BookRequest request) throws MappingDtoException;

    BookResponse toDto(Book book) throws MappingDtoException;

    List<Book> toDomainList(List<BookRequest> booksRequested) throws MappingDtoException;

    List<BookResponse> toDtoList(List<Book> books) throws MappingDtoException;


}
