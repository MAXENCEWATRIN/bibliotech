package com.maxencew.biblioto.domain.adapter;

import com.maxencew.biblioto.application.service.api.LibraryService;
import com.maxencew.biblioto.domain.model.Library;
import com.maxencew.biblioto.domain.ports.spi.LibraryPersistencePort;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Slf4j
@AllArgsConstructor
public class LibraryServiceAdapter implements LibraryService {

    @Autowired
    private final LibraryPersistencePort libraryPersistencePort;

    public Library addLibrary(Library library) {
        return this.libraryPersistencePort.addLibrary(library);
    }

    public void removeLibrary(Library library) {
        this.libraryPersistencePort.removeLibrary(library);
    }

    public List<Library> getLibraries() {
        return this.libraryPersistencePort.getLibrarys();
    }

    public Library getLibraryById(Long id) {
        return this.libraryPersistencePort.getLibraryById(id);
    }


}
