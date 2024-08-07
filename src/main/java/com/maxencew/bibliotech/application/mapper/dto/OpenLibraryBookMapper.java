package com.maxencew.bibliotech.application.mapper.dto;

import com.maxencew.bibliotech.application.exception.MappingException;
import com.maxencew.bibliotech.domain.model.Book;
import com.maxencew.bibliotech.infrastructure.external.OpenLibraryBookApiResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring", uses = {EditorDtoMapper.class})
//TODO : travailler sur un mapper mapStruct une fois le reste consolidé
public interface OpenLibraryBookMapper {

//    @Mapping(source = "title", target = "isbnId")
//    @Mapping(source = "title", target = "oldIsbnId")
//    @Mapping(source = "title", target = "title")
//    @Mapping(source = "title", target = "authorName")
//    @Mapping(source = "title", target = "titleLong")
//    @Mapping(source = "title", target = "subtitle")
//    @Mapping(source = "title", target = "summary")
//    @Mapping(source = "title", target = "synopsis")
//    @Mapping(source = "title", target = "numberOfPage")
//    @Mapping(source = "title", target = "openLibraryId")
//    @Mapping(source = "title", target = "coverPageUrl")
//    @Mapping(source = "title", target = "traductionLanguage")
//    @Mapping(source = "title", target = "initialLanguage")
//    @Mapping(source = "title", target = "firstPublishYear")
//    @Mapping(source = "title", target = "firstSentence")
//    @Mapping(source = "title", target = "editorMapper")
    Book toDomain(OpenLibraryBookApiResponse bookOpenLibrary) throws MappingException;

    @Named("mapAuthorToAuthorNameList")
    static List<String> mapAuthorToAuthorNameList(String author) {
        return author != null ? List.of(author) : List.of();
    }
}
