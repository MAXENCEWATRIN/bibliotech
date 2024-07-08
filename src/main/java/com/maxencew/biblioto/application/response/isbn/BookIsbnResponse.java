package com.maxencew.biblioto.application.response.isbn;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class BookIsbnResponse {
    private String title;
    private String titleLong;
    private String isbn;
    private String isbn13;
    private String deweyDecimal;
    private String binding;
    private String publisher;
    private String language;
    private LocalDateTime datePublished;
    private String edition;
    private int pages;
    private String dimensions;
    private String overview;
    private String image;
    private int msrp;
    private String excerpt;
    private String synopsis;
    private List<String> authors;
    private List<String> subjects;
    private List<String> reviews;
    private List<Price> prices;
    private Related related;
    private List<OtherIsbn> otherIsbns;
}
