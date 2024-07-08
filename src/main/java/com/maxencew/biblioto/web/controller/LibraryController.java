package com.maxencew.biblioto.infrastructure.controller;

import com.maxencew.biblioto.application.mapper.LibraryDtoMapper;
import com.maxencew.biblioto.application.request.LibraryRequest;
import com.maxencew.biblioto.application.response.LibraryResponse;
import com.maxencew.biblioto.application.service.adapter.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/libraries")
public class LibraryController {

    @Autowired
    private LibraryService libraryService;

    @Autowired
    private LibraryDtoMapper libraryDtoMapper;

    @PostMapping
    public LibraryResponse addLibrary(@RequestBody LibraryRequest library) {
        return libraryDtoMapper.toDto(libraryService.add(libraryDtoMapper.toDomain(library)));
    }

    @PutMapping("/{id}")
    public LibraryResponse updateLibrary(@PathVariable Long id, @RequestBody LibraryRequest library) {
        library.setId(id);
        return libraryDtoMapper.toDto(libraryService.add(libraryDtoMapper.toDomain(library)));
    }

    @DeleteMapping("/{id}")
    public void deleteLibrary(@PathVariable Long id, @RequestBody LibraryRequest library) {
        library.setId(id);
        libraryService.delete(libraryDtoMapper.toDomain(library));
    }

    @GetMapping
    public List<LibraryResponse> getAllLibraries() {
        return libraryDtoMapper.toDtoList(libraryService.getAll());
    }

    @GetMapping("/{id}")
    public LibraryResponse getLibraryById(@PathVariable Long id) {
        return libraryDtoMapper.toDto(libraryService.getById(id));
    }

}
