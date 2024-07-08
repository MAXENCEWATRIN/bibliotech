package com.maxencew.biblioto.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
public class Editor {

    private Long id;
    private String name;
    private String category;
    private String edition;
}
