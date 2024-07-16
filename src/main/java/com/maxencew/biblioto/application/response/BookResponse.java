package com.maxencew.biblioto.application.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.bson.types.ObjectId;

import java.math.BigDecimal;
import java.util.List;

@Data

@AllArgsConstructor
public class BookResponse {
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
    private ObjectId coverImageId;
    private String traductionLanguage;
    private String initialLanguage;
    private Integer firstPublishYear;
    private String firstSentence;
    private EditorResponse editor;
    private LibraryResponse library;
    private List<ThemeResponse> themes;
    private OwnerResponse owner;
    private Boolean isWishList;
    private String overallReception;
    private String praises;
    private String criticisms;
    private Boolean isAnOpenLibaryApiRegister;
    private Boolean isAnOpenLibaryApiBookValidate;

}
