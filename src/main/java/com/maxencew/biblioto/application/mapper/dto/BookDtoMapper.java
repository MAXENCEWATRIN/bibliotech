package com.maxencew.biblioto.application.mapper.dto;

import com.maxencew.biblioto.application.exception.MappingDtoException;
import com.maxencew.biblioto.application.request.BookRequest;
import com.maxencew.biblioto.application.response.BookResponse;
import com.maxencew.biblioto.domain.model.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookDtoMapper {

    @Mapping(target = "id", ignore = true)
    Book toDomain(BookRequest request) throws MappingDtoException;

    BookResponse toDto(Book book) throws MappingDtoException;

    List<Book> toDomainList(List<BookRequest> booksRequested) throws MappingDtoException;

    List<BookResponse> toDtoList(List<Book> books) throws MappingDtoException;


}
