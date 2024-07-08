package com.maxencew.biblioto.application.service.adapter;

import com.maxencew.biblioto.application.mapper.LibraryEntityMapper;
import com.maxencew.biblioto.domain.model.Library;
import com.maxencew.biblioto.infrastructure.repository.LibraryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class LibraryService {

    private final LibraryRepository libraryRepository;
    private final LibraryEntityMapper libraryEntityMapper;

    @Autowired
    public LibraryService(LibraryRepository libraryRepository, LibraryEntityMapper libraryEntityMapper) {
        this.libraryRepository = libraryRepository;
        this.libraryEntityMapper = libraryEntityMapper;
    }

    public Library add(Library library) {
        return libraryEntityMapper.toDomain(this.libraryRepository.save(libraryEntityMapper.toEntity(library)));
    }

    public void delete(Library library) {
        this.libraryRepository.delete(libraryEntityMapper.toEntity(library));
    }

    public List<Library> getAll() {
        return libraryEntityMapper.toDomainList(this.libraryRepository.findAll());
    }

    public Library getById(Long id) {
        return libraryEntityMapper.toDomain(this.libraryRepository.getReferenceById(id));
    }

}
