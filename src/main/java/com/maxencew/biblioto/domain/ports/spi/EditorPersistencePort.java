package com.maxencew.biblioto.domain.ports.spi;

import com.maxencew.biblioto.domain.model.Editor;

import java.util.List;

public interface EditorPersistencePort {

    Editor addEditor(Editor editor);

    void removeEditor(Editor editor);

    List<Editor> getEditors();

    Editor getEditorById(Long editorId);
}
