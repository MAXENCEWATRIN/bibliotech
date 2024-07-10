package com.maxencew.biblioto.application.mapper.dto;

import com.maxencew.biblioto.application.exception.MappingDtoException;
import com.maxencew.biblioto.application.request.EditorRequest;
import com.maxencew.biblioto.application.response.EditorResponse;
import com.maxencew.biblioto.domain.model.Editor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EditorDtoMapper {

    @Mapping(target = "id", ignore = true)
    Editor toDomain(EditorRequest request) throws MappingDtoException;

    @Mapping(target = "books", ignore = true)
    EditorResponse toDto(Editor editor) throws MappingDtoException; 

    List<Editor> toDomainList(List<EditorRequest> editorRequests) throws MappingDtoException; 

    List<EditorResponse> toDtoList(List<Editor> editors) throws MappingDtoException; 


}
