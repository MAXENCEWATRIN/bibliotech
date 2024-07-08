package com.maxencew.biblioto.application.mapper;

import com.maxencew.biblioto.domain.model.Editor;
import com.maxencew.biblioto.infrastructure.entity.EditorEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-08T18:30:18+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class EditorEntityMapperImpl implements EditorEntityMapper {

    @Override
    public EditorEntity toEntity(Editor editor) {
        if ( editor == null ) {
            return null;
        }

        EditorEntity.EditorEntityBuilder editorEntity = EditorEntity.builder();

        return editorEntity.build();
    }

    @Override
    public Editor toDomain(EditorEntity editor) {
        if ( editor == null ) {
            return null;
        }

        Editor.EditorBuilder editor1 = Editor.builder();

        return editor1.build();
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
