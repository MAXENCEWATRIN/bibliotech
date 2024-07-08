package com.maxencew.biblioto.application.mapper;

import com.maxencew.biblioto.application.request.EditorRequest;
import com.maxencew.biblioto.application.response.EditorResponse;
import com.maxencew.biblioto.domain.model.Editor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EditorDtoMapper {

    @Mapping(target = "id", ignore = true)
    Editor toDomain(EditorRequest request);

    EditorResponse toDto(Editor editor);

    List<Editor> toDomainList(List<EditorRequest> editorRequests);

    List<EditorResponse> toDtoList(List<Editor> editors);


}
