package com.maxencew.bibliotech.application.web.restController;

import com.maxencew.bibliotech.application.mapper.dto.LibraryDtoMapper;
import com.maxencew.bibliotech.application.request.LibraryRequest;
import com.maxencew.bibliotech.application.response.BibliotechHttpResponse;
import com.maxencew.bibliotech.application.response.LibraryResponse;
import com.maxencew.bibliotech.domain.ports.api.LibraryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/libraries")
public class LibraryController {

    @Autowired
    private LibraryService libraryServiceAdapter;

    @Autowired
    private LibraryDtoMapper libraryDtoMapper;

    @PostMapping
    public BibliotechHttpResponse<LibraryResponse> addLibrary(@Valid  @RequestBody LibraryRequest library) {
        return BibliotechHttpResponse.success(libraryDtoMapper.toDto(libraryServiceAdapter.addLibrary(libraryDtoMapper.toDomain(library))));
    }

    @PutMapping("/{id}")
    public BibliotechHttpResponse<LibraryResponse> updateLibrary(@PathVariable Long id, @Valid @RequestBody LibraryRequest library) {
        library.setId(id);
        return BibliotechHttpResponse.success(libraryDtoMapper.toDto(libraryServiceAdapter.addLibrary(libraryDtoMapper.toDomain(library))));
    }

    @DeleteMapping("/{id}")
    public void deleteLibrary(@PathVariable Long id, @RequestBody LibraryRequest library) {
        library.setId(id);
        libraryServiceAdapter.removeLibrary(libraryDtoMapper.toDomain(library));
    }

    @GetMapping
    public BibliotechHttpResponse<List<LibraryResponse>> getAllLibraries() {
        return BibliotechHttpResponse.success(libraryDtoMapper.toDtoList(libraryServiceAdapter.getLibraries()));
    }

    @GetMapping("/{id}")
    public BibliotechHttpResponse<LibraryResponse> getLibraryById(@PathVariable Long id) {
        return BibliotechHttpResponse.success(libraryDtoMapper.toDto(libraryServiceAdapter.getLibraryById(id)));
    }

}
