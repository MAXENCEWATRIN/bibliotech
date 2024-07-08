package com.maxencew.biblioto.application.service.api;

import com.maxencew.biblioto.domain.model.Library;

import java.util.List;

public interface LibraryService {

    Library addLibrary(Library library);

    void removeLibrary(Library library);

    List<Library> getLibraries();

    Library getLibraryById(Long libraryId);
}
