package com.maxencew.biblioto.web.controller;

import com.maxencew.biblioto.application.mapper.EditorDtoMapper;
import com.maxencew.biblioto.application.request.EditorRequest;
import com.maxencew.biblioto.application.response.EditorResponse;
import com.maxencew.biblioto.application.service.adapter.EditorServiceAdapter;
import com.maxencew.biblioto.application.service.api.EditorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/editors")
public class EditorController {

    @Autowired
    private EditorService editorServiceAdapter;

    @Autowired
    private EditorDtoMapper editorDtoMapper;

    @PostMapping
    public EditorResponse addEditor(@RequestBody EditorRequest editor) {
        return editorDtoMapper.toDto(editorServiceAdapter.addEditor(editorDtoMapper.toDomain(editor)));
    }

    @PutMapping("/{id}")
    public EditorResponse updateEditor(@PathVariable Long id, @RequestBody EditorRequest editor) {
        editor.setId(id);
        return editorDtoMapper.toDto(editorServiceAdapter.addEditor(editorDtoMapper.toDomain(editor)));
    }

    @DeleteMapping("/{id}")
    public void deleteEditor(@PathVariable Long id, @RequestBody EditorRequest editor) {
        editor.setId(id);
        editorServiceAdapter.removeEditor(editorDtoMapper.toDomain(editor));
    }

    @GetMapping
    public List<EditorResponse> getAllEditors() {
        return editorDtoMapper.toDtoList(editorServiceAdapter.getEditors());
    }

    @GetMapping("/{id}")
    public EditorResponse getEditorById(@PathVariable Long id) {
        return editorDtoMapper.toDto(editorServiceAdapter.getEditorById(id));
    }

}
