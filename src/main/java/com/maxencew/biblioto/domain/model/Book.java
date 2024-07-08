package com.maxencew.biblioto.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book {

    private Long id;
    private Integer isbnId;
    private String title;
    private String titleLong;
    private String subtitle;
    private String synopsis;
    private String summary;
    private Integer numberPage;
    private String coverPage;
    private String traductionLanguage;
    private String initialLanguage;
    private Editor editor;


}
