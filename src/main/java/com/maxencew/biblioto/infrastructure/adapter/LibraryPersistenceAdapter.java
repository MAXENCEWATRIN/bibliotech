package com.maxencew.biblioto.infrastructure.adapter;

import com.maxencew.biblioto.application.mapper.LibraryEntityMapper;
import com.maxencew.biblioto.domain.model.Library;
import com.maxencew.biblioto.domain.ports.spi.LibraryPersistencePort;
import com.maxencew.biblioto.infrastructure.repository.LibraryRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public class LibraryPersistenceAdapter implements LibraryPersistencePort {

    private final LibraryRepository libraryRepository;
    private final LibraryEntityMapper libraryEntityMapper;

    public LibraryPersistenceAdapter(LibraryRepository libraryRepository, LibraryEntityMapper libraryEntityMapper) {
        this.libraryRepository = libraryRepository;
        this.libraryEntityMapper = libraryEntityMapper;
    }

    @Override
    public Library addLibrary(Library library) {
       return  libraryEntityMapper.toDomain(libraryRepository.save(libraryEntityMapper.toEntity(library)));
    }

    @Override
    public void removeLibrary(Library library) {
        libraryRepository.delete(libraryEntityMapper.toEntity(library));
    }

    @Override
    public List<Library> getLibrarys() {
       return libraryEntityMapper.toDomainList(libraryRepository.findAll());
    }

    @Override
    public Library getLibraryById(Long libraryId) {
        return libraryEntityMapper.toDomain(this.libraryRepository.getReferenceById(libraryId));
    }

}
