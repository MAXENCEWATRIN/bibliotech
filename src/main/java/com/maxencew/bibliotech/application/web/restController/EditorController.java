package com.maxencew.bibliotech.application.web.restController;

import com.maxencew.bibliotech.application.mapper.dto.EditorDtoMapper;
import com.maxencew.bibliotech.application.request.EditorRequest;
import com.maxencew.bibliotech.application.response.BibliotechHttpResponse;
import com.maxencew.bibliotech.application.response.EditorResponse;
import com.maxencew.bibliotech.application.service.api.EditorService;
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
    public BibliotechHttpResponse<EditorResponse> addEditor(@Valid @RequestBody EditorRequest editor) {
        return BibliotechHttpResponse.success(editorDtoMapper.toDto(editorServiceAdapter.addEditor(editorDtoMapper.toDomain(editor))));
    }

    @PutMapping("/{id}")
    public BibliotechHttpResponse<EditorResponse> updateEditor(@Valid @PathVariable Long id, @RequestBody EditorRequest editor) {
        editor.setId(id);
        return BibliotechHttpResponse.success(editorDtoMapper.toDto(editorServiceAdapter.addEditor(editorDtoMapper.toDomain(editor))));
    }

    @DeleteMapping("/{id}")
    public void deleteEditor(@PathVariable Long id, @RequestBody EditorRequest editor) {
        editor.setId(id);
        editorServiceAdapter.removeEditor(editorDtoMapper.toDomain(editor));
    }

    @GetMapping
    public BibliotechHttpResponse<List<EditorResponse>> getAllEditors() {
        return BibliotechHttpResponse.success(editorDtoMapper.toDtoList(editorServiceAdapter.getEditors()));
    }

    @GetMapping("/{id}")
    public BibliotechHttpResponse<EditorResponse> getEditorById(@PathVariable Long id) {
        return BibliotechHttpResponse.success(editorDtoMapper.toDto(editorServiceAdapter.getEditorById(id)));
    }

}
