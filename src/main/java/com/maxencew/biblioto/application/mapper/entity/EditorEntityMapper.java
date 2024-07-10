package com.maxencew.biblioto.application.mapper.entity;

import com.maxencew.biblioto.application.exception.MappingEntityException;
import com.maxencew.biblioto.infrastructure.entity.EditorEntity;
import com.maxencew.biblioto.domain.model.Editor;
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
