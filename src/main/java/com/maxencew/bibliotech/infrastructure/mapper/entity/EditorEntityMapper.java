package com.maxencew.bibliotech.infrastructure.mapper.entity;

import com.maxencew.bibliotech.application.exception.MappingEntityException;
import com.maxencew.bibliotech.domain.model.Editor;
import com.maxencew.bibliotech.infrastructure.entity.EditorEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EditorEntityMapper {

    @Mapping(target = "books", ignore = true)
    EditorEntity toEntity(Editor editor) throws MappingEntityException;

    Editor toDomain(EditorEntity editor) throws MappingEntityException; 

    List<Editor> toDomainList(List<EditorEntity> entities) throws MappingEntityException; 

    List<EditorEntity> toEntityList(List<Editor> editors) throws MappingEntityException; 


}
