package com.maxencew.biblioto.application.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor

public class EditorResponse {

    private Long id;
    private String name;
    private String category;
    private String edition;
    private List<BookResponse> books;
}
