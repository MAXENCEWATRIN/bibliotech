package com.maxencew.biblioto.application.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class BookRequest {

    private Long id;
    private BigDecimal isbnId;
    private BigDecimal oldIsbnId;
    private String title;
    private String authorName;
    private String titleLong;
    private String subtitle;
    private String synopsis;
    private String summary;
    private Integer numberOfPage;
    private String openLibraryId;
    private String coverPageUrl;
    private String traductionLanguage;
    private String initialLanguage;
    private Integer firstPublishYear;
    private String firstSentence;
    private EditorRequest editor;
    private LibraryRequest library;
    private List<ThemeRequest> themes;
    private OwnerRequest owner;
    private Boolean isWishList;
    private Boolean isAnOpenLibaryApiRegister;
    private Boolean isAnOpenLibaryApiBookValidate;

}


