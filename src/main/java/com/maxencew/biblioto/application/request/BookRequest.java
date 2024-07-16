package com.maxencew.biblioto.application.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.bson.types.ObjectId;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class BookRequest {

    private Long id;
    private BigDecimal isbnId;
    private BigDecimal oldIsbnId;
    @NotBlank(message = "Title is required")
    private String title;
    @NotBlank(message = "AuthorName is required")
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
    private EditorRequest editor;
    private LibraryRequest library;
    private List<ThemeRequest> themes;
    private OwnerRequest owner;
    private Boolean isWishList;
    private String overallReception;
    private String praises;
    private String criticisms;
    private Boolean isAnOpenLibaryApiRegister;
    private Boolean isAnOpenLibaryApiBookValidate;

}


