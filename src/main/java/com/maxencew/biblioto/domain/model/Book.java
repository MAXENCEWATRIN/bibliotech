package com.maxencew.biblioto.domain.model;

import com.maxencew.biblioto.application.request.ThemeRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book {

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
    private Editor editor;
    private Library library;
    private Owner owner;
    private List<Theme> themes;
    private Boolean isWishList;
    private Boolean isAnOpenLibaryApiRegister;
    private Boolean isAnOpenLibaryApiBookValidate;


}
