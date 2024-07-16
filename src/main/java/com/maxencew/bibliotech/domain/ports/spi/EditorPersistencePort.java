package com.maxencew.bibliotech.domain.ports.spi;

import com.maxencew.bibliotech.domain.model.Editor;

import java.util.List;

public interface EditorPersistencePort {

    Editor addEditor(Editor editor);

    void removeEditor(Editor editor);

    List<Editor> getEditors();

    Editor getEditorById(Long editorId);
}
