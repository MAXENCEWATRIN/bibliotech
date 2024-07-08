package com.maxencew.biblioto.application.mapper;

import com.maxencew.biblioto.infrastructure.entity.LibraryEntity;
import com.maxencew.biblioto.domain.model.Library;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LibraryEntityMapper {

    @Mapping(target = "withId", ignore = true)
    LibraryEntity toEntity(Library library);

    Library toDomain(LibraryEntity libraryEntity);

    List<Library> toDomainList(List<LibraryEntity> entities);

    List<LibraryEntity> toEntityList(List<Library> libraries);


}
