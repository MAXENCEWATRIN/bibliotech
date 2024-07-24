package com.maxencew.bibliotech.application.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class EditorResponse {

    private Long id;
    private String name;
    private String category;
    private String edition;
}
