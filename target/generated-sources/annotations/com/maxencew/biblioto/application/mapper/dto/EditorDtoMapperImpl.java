package com.maxencew.biblioto.application.mapper.dto;

import com.maxencew.biblioto.application.exception.MappingDtoException;
import com.maxencew.biblioto.application.request.EditorRequest;
import com.maxencew.biblioto.application.response.EditorResponse;
import com.maxencew.biblioto.domain.model.Editor;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-17T00:15:41+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class EditorDtoMapperImpl implements EditorDtoMapper {

    @Override
    public Editor toDomain(EditorRequest request) throws MappingDtoException {
        if ( request == null ) {
            return null;
        }

        Editor.EditorBuilder editor = Editor.builder();

        editor.id( request.getId() );
        editor.name( request.getName() );
        editor.category( request.getCategory() );
        editor.edition( request.getEdition() );

        return editor.build();
    }

    @Override
    public EditorResponse toDto(Editor editor) throws MappingDtoException {
        if ( editor == null ) {
            return null;
        }

        Long id = null;
        String name = null;
        String category = null;
        String edition = null;

        id = editor.getId();
        name = editor.getName();
        category = editor.getCategory();
        edition = editor.getEdition();

        EditorResponse editorResponse = new EditorResponse( id, name, category, edition );

        return editorResponse;
    }

    @Override
    public List<Editor> toDomainList(List<EditorRequest> editorRequests) throws MappingDtoException {
        if ( editorRequests == null ) {
            return null;
        }

        List<Editor> list = new ArrayList<Editor>( editorRequests.size() );
        for ( EditorRequest editorRequest : editorRequests ) {
            list.add( toDomain( editorRequest ) );
        }

        return list;
    }

    @Override
    public List<EditorResponse> toDtoList(List<Editor> editors) throws MappingDtoException {
        if ( editors == null ) {
            return null;
        }

        List<EditorResponse> list = new ArrayList<EditorResponse>( editors.size() );
        for ( Editor editor : editors ) {
            list.add( toDto( editor ) );
        }

        return list;
    }
}
