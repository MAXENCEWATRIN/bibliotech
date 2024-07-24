package com.maxencew.bibliotech.infrastructure.mapper.entity;

import com.maxencew.bibliotech.application.exception.MappingEntityException;
import com.maxencew.bibliotech.domain.model.Book;
import com.maxencew.bibliotech.infrastructure.entity.BookEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookEntityMapper {

    BookEntity toEntity(Book book) throws MappingEntityException;

    Book toDomain(BookEntity bookEntity) throws MappingEntityException;

    List<Book> toDomainList(List<BookEntity> entities) throws MappingEntityException;

    List<BookEntity> toEntityList(List<Book> books) throws MappingEntityException;


}
