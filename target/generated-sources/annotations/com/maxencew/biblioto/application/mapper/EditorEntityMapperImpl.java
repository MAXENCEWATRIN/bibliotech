package com.maxencew.biblioto.application.mapper;

import com.maxencew.biblioto.domain.model.Editor;
import com.maxencew.biblioto.infrastructure.entity.EditorEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-08T20:20:22+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class EditorEntityMapperImpl implements EditorEntityMapper {

    @Override
    public EditorEntity toEntity(Editor editor) {
        if ( editor == null ) {
            return null;
        }

        String name = null;
        String category = null;

        name = editor.getName();
        category = editor.getCategory();

        Long id = null;

        EditorEntity editorEntity = new EditorEntity( id, name, category );

        return editorEntity;
    }

    @Override
    public Editor toDomain(EditorEntity editor) {
        if ( editor == null ) {
            return null;
        }

        Long id = null;
        String name = null;
        String category = null;

        id = editor.getId();
        name = editor.getName();
        category = editor.getCategory();

        String edition = null;

        Editor editor1 = new Editor( id, name, category, edition );

        return editor1;
    }

    @Override
    public List<Editor> toDomainList(List<EditorEntity> entities) {
        if ( entities == null ) {
            return null;
        }

        List<Editor> list = new ArrayList<Editor>( entities.size() );
        for ( EditorEntity editorEntity : entities ) {
            list.add( toDomain( editorEntity ) );
        }

        return list;
    }

    @Override
    public List<EditorEntity> toEntityList(List<Editor> editors) {
        if ( editors == null ) {
            return null;
        }

        List<EditorEntity> list = new ArrayList<EditorEntity>( editors.size() );
        for ( Editor editor : editors ) {
            list.add( toEntity( editor ) );
        }

        return list;
    }
}
