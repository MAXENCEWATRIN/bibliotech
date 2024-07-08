package com.maxencew.biblioto.application.service.api;

import com.maxencew.biblioto.domain.model.Editor;

import java.util.List;

public interface EditorService {

    Editor addEditor(Editor editor);

    void removeEditor(Editor editor);

    List<Editor> getEditors();

    Editor getEditorById(Long editorId);
}
