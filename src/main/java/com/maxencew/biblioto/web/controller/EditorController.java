package com.maxencew.biblioto.web.controller;

import com.maxencew.biblioto.application.mapper.dto.EditorDtoMapper;
import com.maxencew.biblioto.application.request.EditorRequest;
import com.maxencew.biblioto.application.response.EditorResponse;
import com.maxencew.biblioto.application.response.BibliotoHttpResponse;
import com.maxencew.biblioto.application.service.api.EditorService;
import jakarta.validation.Valid;
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
    public BibliotoHttpResponse<EditorResponse> addEditor(@Valid @RequestBody EditorRequest editor) {
        return BibliotoHttpResponse.success(editorDtoMapper.toDto(editorServiceAdapter.addEditor(editorDtoMapper.toDomain(editor))));
    }

    @PutMapping("/{id}")
    public BibliotoHttpResponse<EditorResponse> updateEditor(@Valid @PathVariable Long id, @RequestBody EditorRequest editor) {
        editor.setId(id);
        return BibliotoHttpResponse.success(editorDtoMapper.toDto(editorServiceAdapter.addEditor(editorDtoMapper.toDomain(editor))));
    }

    @DeleteMapping("/{id}")
    public void deleteEditor(@PathVariable Long id, @RequestBody EditorRequest editor) {
        editor.setId(id);
        editorServiceAdapter.removeEditor(editorDtoMapper.toDomain(editor));
    }

    @GetMapping
    public BibliotoHttpResponse<List<EditorResponse>> getAllEditors() {
        return BibliotoHttpResponse.success(editorDtoMapper.toDtoList(editorServiceAdapter.getEditors()));
    }

    @GetMapping("/{id}")
    public BibliotoHttpResponse<EditorResponse> getEditorById(@PathVariable Long id) {
        return BibliotoHttpResponse.success(editorDtoMapper.toDto(editorServiceAdapter.getEditorById(id)));
    }

}
