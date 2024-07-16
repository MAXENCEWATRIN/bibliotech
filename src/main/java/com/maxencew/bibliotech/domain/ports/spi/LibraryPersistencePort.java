package com.maxencew.bibliotech.domain.ports.spi;

import com.maxencew.bibliotech.domain.model.Library;

import java.util.List;

public interface LibraryPersistencePort {

    Library addLibrary(Library library);

    void removeLibrary(Library library);

    List<Library> getLibrarys();

    Library getLibraryById(Long libraryId);

}
