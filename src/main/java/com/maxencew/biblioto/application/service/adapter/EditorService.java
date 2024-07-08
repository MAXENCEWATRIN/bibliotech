package com.maxencew.biblioto.application.service.adapter;

import com.maxencew.biblioto.application.mapper.EditorEntityMapper;
import com.maxencew.biblioto.domain.model.Editor;
import com.maxencew.biblioto.infrastructure.repository.EditorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class EditorService {

    private final EditorRepository editorRepository;
    private final  EditorEntityMapper editorEntityMapper;

    @Autowired
    public EditorService(EditorRepository editorRepository, EditorEntityMapper editorEntityMapper) {
        this.editorRepository = editorRepository;
        this.editorEntityMapper = editorEntityMapper;
    }

    public Editor add(Editor editor) {
        return editorEntityMapper.toDomain(this.editorRepository.save(editorEntityMapper.toEntity(editor)));
    }

    public void delete(Editor editor) {
        this.editorRepository.delete(editorEntityMapper.toEntity(editor));
    }

    public List<Editor> getAll() {
        return editorEntityMapper.toDomainList(this.editorRepository.findAll());
    }

    public Editor getById(Long id) {
        return editorEntityMapper.toDomain(this.editorRepository.getReferenceById(id));
    }

}
