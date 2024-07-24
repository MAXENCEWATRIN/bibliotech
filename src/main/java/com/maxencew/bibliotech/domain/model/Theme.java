package com.maxencew.bibliotech.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Theme {

    private Long id;
    private String name;
    private List<String> keywords;

}
