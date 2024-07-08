package com.maxencew.biblioto.infrastructure.controller;

import com.maxencew.biblioto.application.mapper.EditorDtoMapper;
import com.maxencew.biblioto.application.request.EditorRequest;
import com.maxencew.biblioto.application.response.EditorResponse;
import com.maxencew.biblioto.application.service.adapter.EditorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/libraries")
public class EditorController {

    @Autowired
    private EditorService editorService;

    @Autowired
    private EditorDtoMapper editorDtoMapper;

    @PostMapping
    public EditorResponse addEditor(@RequestBody EditorRequest editor) {
        return editorDtoMapper.toDto(editorService.add(editorDtoMapper.toDomain(editor)));
    }

    @PutMapping("/{id}")
    public EditorResponse updateEditor(@PathVariable Long id, @RequestBody EditorRequest editor) {
        editor.setId(id);
        return editorDtoMapper.toDto(editorService.add(editorDtoMapper.toDomain(editor)));
    }

    @DeleteMapping("/{id}")
    public void deleteEditor(@PathVariable Long id, @RequestBody EditorRequest editor) {
        editor.setId(id);
        editorService.delete(editorDtoMapper.toDomain(editor));
    }

    @GetMapping
    public List<EditorResponse> getAllEditors() {
        return editorDtoMapper.toDtoList(editorService.getAll());
    }

    @GetMapping("/{id}")
    public EditorResponse getEditorById(@PathVariable Long id) {
        return editorDtoMapper.toDto(editorService.getById(id));
    }

}
