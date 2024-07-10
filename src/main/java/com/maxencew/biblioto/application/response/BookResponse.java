package com.maxencew.biblioto.application.response;

import com.maxencew.biblioto.application.request.LibraryRequest;
import com.maxencew.biblioto.domain.model.Editor;
import com.maxencew.biblioto.domain.model.Library;
import com.maxencew.biblioto.domain.model.Owner;
import com.maxencew.biblioto.domain.model.Theme;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

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
    private String traductionLanguage;
    private String initialLanguage;
    private Integer firstPublishYear;
    private String firstSentence;
    private EditorResponse editor;
    private LibraryResponse library;
    private List<ThemeResponse> themes;
    private OwnerResponse owner;
    private Boolean isWishList;
    private Boolean isAnOpenLibaryApiRegister;
    private Boolean isAnOpenLibaryApiBookValidate;

}
