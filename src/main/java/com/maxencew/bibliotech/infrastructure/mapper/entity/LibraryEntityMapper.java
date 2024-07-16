package com.maxencew.bibliotech.infrastructure.mapper.entity;

import com.maxencew.bibliotech.application.exception.MappingEntityException;
import com.maxencew.bibliotech.infrastructure.entity.LibraryEntity;
import com.maxencew.bibliotech.domain.model.Library;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LibraryEntityMapper {

    @Mapping(target = "books", ignore = true)
    LibraryEntity toEntity(Library library) throws MappingEntityException;

    Library toDomain(LibraryEntity libraryEntity) throws MappingEntityException; 

    List<Library> toDomainList(List<LibraryEntity> entities) throws MappingEntityException; 

    List<LibraryEntity> toEntityList(List<Library> libraries) throws MappingEntityException; 


}
