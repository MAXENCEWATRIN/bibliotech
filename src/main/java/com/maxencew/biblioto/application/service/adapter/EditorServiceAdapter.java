package com.maxencew.biblioto.application.service.adapter;

import com.maxencew.biblioto.application.service.api.EditorService;
import com.maxencew.biblioto.domain.model.Editor;
import com.maxencew.biblioto.domain.ports.spi.EditorPersistencePort;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@Slf4j
@AllArgsConstructor
public class EditorServiceAdapter implements EditorService {

    @Autowired
    private final EditorPersistencePort editorPersistencePort;

    public Editor addEditor(Editor editor) {
        return this.editorPersistencePort.addEditor(editor);
    }

    public void removeEditor(Editor editor) {
        this.editorPersistencePort.removeEditor(editor);
    }

    public List<Editor> getEditors() {
        return this.editorPersistencePort.getEditors();
    }

    public Editor getEditorById(Long id) {
        return this.editorPersistencePort.getEditorById(id);
    }


}
