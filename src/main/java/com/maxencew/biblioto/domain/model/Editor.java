package com.maxencew.biblioto.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder(setterPrefix = "with")
public class Editor {

    private String name;
    private String category;
    private String edition;
}
