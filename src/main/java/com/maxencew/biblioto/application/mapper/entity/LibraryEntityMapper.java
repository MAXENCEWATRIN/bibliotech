package com.maxencew.biblioto.application.mapper.entity;

import com.maxencew.biblioto.application.exception.MappingEntityException;
import com.maxencew.biblioto.infrastructure.entity.LibraryEntity;
import com.maxencew.biblioto.domain.model.Library;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LibraryEntityMapper {

    @Mapping(target = "books", ignore = true)
    @Mapping(target = "id", ignore = true)
    LibraryEntity toEntity(Library library) throws MappingEntityException;

    Library toDomain(LibraryEntity libraryEntity) throws MappingEntityException; 

    List<Library> toDomainList(List<LibraryEntity> entities) throws MappingEntityException; 

    List<LibraryEntity> toEntityList(List<Library> libraries) throws MappingEntityException; 


}
