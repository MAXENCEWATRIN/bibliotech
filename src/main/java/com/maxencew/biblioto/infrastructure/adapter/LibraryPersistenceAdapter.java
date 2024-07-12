package com.maxencew.biblioto.infrastructure.adapter;

import com.maxencew.biblioto.application.exception.MappingEntityException;
import com.maxencew.biblioto.infrastructure.mapper.entity.LibraryEntityMapper;
import com.maxencew.biblioto.domain.model.Library;
import com.maxencew.biblioto.domain.ports.spi.LibraryPersistencePort;
import com.maxencew.biblioto.infrastructure.entity.LibraryEntity;
import com.maxencew.biblioto.infrastructure.exception.AppPersistenceException;
import com.maxencew.biblioto.infrastructure.repository.LibraryRepository;
import org.springframework.stereotype.Component;

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
        LibraryEntity libraryEntity = libraryEntityMapper.toEntity(library);
        LibraryEntity persistedLibrary;
        try {
            persistedLibrary = libraryRepository.save(libraryEntity);
        } catch (Exception e) {
            throw new AppPersistenceException(e.getMessage(), e);
        }
        return  libraryEntityMapper.toDomain(persistedLibrary);
    }

    //TODO : Dans toutes mes exceptions propager la cause correctement
    @Override
    public void removeLibrary(Library library) {
        LibraryEntity libraryEntity = libraryEntityMapper.toEntity(library);
        try {
            libraryRepository.delete(libraryEntity);
        } catch (Exception e) {
            throw new AppPersistenceException(e.getMessage(), e);
        }
    }

    @Override
    public List<Library> getLibrarys() {
        List<LibraryEntity> libraries = libraryRepository.findAll();
        try {
            return libraryEntityMapper.toDomainList(libraries);
        } catch (MappingEntityException e) {
            throw new AppPersistenceException(e.getMessage(), e);
        }
    }

    @Override
    public Library getLibraryById(Long libraryId) {
        LibraryEntity referenceById;
        try {
            referenceById = this.libraryRepository.getReferenceById(libraryId);
        } catch (Exception e) {
            throw new AppPersistenceException(e.getMessage(), e);
        }
        return libraryEntityMapper.toDomain(referenceById);
    }

}
