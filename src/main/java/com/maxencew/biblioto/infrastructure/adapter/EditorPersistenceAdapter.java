package com.maxencew.biblioto.infrastructure.adapter;

import com.maxencew.biblioto.infrastructure.mapper.entity.EditorEntityMapper;
import com.maxencew.biblioto.domain.model.Editor;
import com.maxencew.biblioto.domain.ports.spi.EditorPersistencePort;
import com.maxencew.biblioto.infrastructure.entity.EditorEntity;
import com.maxencew.biblioto.infrastructure.exception.AppPersistenceException;
import com.maxencew.biblioto.infrastructure.repository.EditorRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EditorPersistenceAdapter implements EditorPersistencePort {

    private final EditorRepository editorRepository;
    private final EditorEntityMapper editorEntityMapper;

    public EditorPersistenceAdapter(EditorRepository editorRepository, EditorEntityMapper editorEntityMapper) {
        this.editorRepository = editorRepository;
        this.editorEntityMapper = editorEntityMapper;
    }

    @Override
    public Editor addEditor(Editor editor) {
        EditorEntity editorEntity = editorEntityMapper.toEntity(editor);
        EditorEntity persistedEditor;
        try {
            persistedEditor = editorRepository.save(editorEntity);
        } catch (Exception e) {
            throw new AppPersistenceException(e.getMessage(), e);
        }
        return  editorEntityMapper.toDomain(persistedEditor);
    }

    @Override
    public void removeEditor(Editor editor) {
        EditorEntity editorEntity = editorEntityMapper.toEntity(editor);
        try {
            editorRepository.delete(editorEntity);
        } catch (Exception e) {
            throw new AppPersistenceException(e.getMessage(), e);
        }
    }

    @Override
    public List<Editor> getEditors() {
        List<EditorEntity> editors;
        try {
            editors = editorRepository.findAll();
        } catch (Exception e) {
            throw new AppPersistenceException(e.getMessage(), e);
        }
        return editorEntityMapper.toDomainList(editors);
    }

    @Override
    public Editor getEditorById(Long editorId) {
        EditorEntity referenceById;
        try {
            referenceById = this.editorRepository.getReferenceById(editorId);
        } catch (Exception e) {
            throw new AppPersistenceException(e.getMessage(), e);
        }
        return editorEntityMapper.toDomain(referenceById);
    }

}
