package com.maxencew.bibliotech.application.mapper.dto;

import com.maxencew.bibliotech.application.exception.MappingDtoException;
import com.maxencew.bibliotech.application.request.EditorRequest;
import com.maxencew.bibliotech.application.response.EditorResponse;
import com.maxencew.bibliotech.domain.model.Editor;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EditorDtoMapper {

    Editor toDomain(EditorRequest request) throws MappingDtoException;

    EditorResponse toDto(Editor editor) throws MappingDtoException; 

    List<Editor> toDomainList(List<EditorRequest> editorRequests) throws MappingDtoException; 

    List<EditorResponse> toDtoList(List<Editor> editors) throws MappingDtoException; 


}
