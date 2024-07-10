package com.maxencew.biblioto.application.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor

public class ThemeResponse {

    private Long id;
    private String name;
    private List<String> keywords;
    private List<BookResponse> books;
}
