package com.maxencew.biblioto.application.mapper;

import com.maxencew.biblioto.infrastructure.entity.EditorEntity;
import com.maxencew.biblioto.domain.model.Editor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EditorEntityMapper {

    @Mapping(target = "withId", ignore = true)
    EditorEntity toEntity(Editor editor);

    Editor toDomain(EditorEntity editor);

    List<Editor> toDomainList(List<EditorEntity> entities);

    List<EditorEntity> toEntityList(List<Editor> editors);


}
