package com.maxencew.biblioto.application.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(setterPrefix = "with")
@AllArgsConstructor
public class BookRequest {

    private Long id;
    private Integer isbnId;
    private String title;
    private String subtitle;
    private String synopsis;
    private String summary;
    private Integer numberPage;
    private String coverPage;
    private String traductionLanguage;
    private String initialLanguage;

}


