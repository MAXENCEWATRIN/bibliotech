package com.maxencew.biblioto.infrastructure.adapter;

import com.maxencew.biblioto.application.mapper.entity.EditorEntityMapper;
import com.maxencew.biblioto.domain.model.Editor;
import com.maxencew.biblioto.domain.ports.spi.EditorPersistencePort;
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
       return  editorEntityMapper.toDomain(editorRepository.save(editorEntityMapper.toEntity(editor)));
    }

    @Override
    public void removeEditor(Editor editor) {
        editorRepository.delete(editorEntityMapper.toEntity(editor));
    }

    @Override
    public List<Editor> getEditors() {
       return editorEntityMapper.toDomainList(editorRepository.findAll());
    }

    @Override
    public Editor getEditorById(Long editorId) {
        return editorEntityMapper.toDomain(this.editorRepository.getReferenceById(editorId));
    }

}
