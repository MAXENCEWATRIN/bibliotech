package com.maxencew.biblioto.domain.ports.api;

import com.maxencew.biblioto.domain.model.Library;

import java.util.List;

public interface LibraryServicePort {

    Library add(Library library);

    void delete(String id);

    Library update(Library library, String id);

    List<Library> getAll();

    Library getById(String id);
}
