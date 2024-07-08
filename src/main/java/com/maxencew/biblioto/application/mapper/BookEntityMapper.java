package com.maxencew.biblioto.application.mapper;

import com.maxencew.biblioto.infrastructure.entity.BookEntity;
import com.maxencew.biblioto.domain.model.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookEntityMapper {

    @Mapping(target = "id", ignore = true)
    BookEntity toEntity(Book book);

    Book toDomain(BookEntity bookEntity);

    List<Book> toDomainList(List<BookEntity> entities);

    List<BookEntity> toEntityList(List<Book> books);


}
