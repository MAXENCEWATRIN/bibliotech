package com.maxencew.bibliotech.infrastructure.adapter;

import com.maxencew.bibliotech.infrastructure.mapper.entity.EditorEntityMapper;
import com.maxencew.bibliotech.domain.model.Editor;
import com.maxencew.bibliotech.domain.ports.spi.EditorPersistencePort;
import com.maxencew.bibliotech.infrastructure.entity.EditorEntity;
import com.maxencew.bibliotech.infrastructure.exception.AppPersistenceException;
import com.maxencew.bibliotech.infrastructure.repository.EditorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class EditorPersistenceAdapter implements EditorPersistencePort {

    private final EditorRepository editorRepository;
    private final EditorEntityMapper editorEntityMapper;

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
