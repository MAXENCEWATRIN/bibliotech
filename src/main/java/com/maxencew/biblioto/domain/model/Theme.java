package com.maxencew.biblioto.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@Builder(setterPrefix = "with")
public class Theme {

    private String name;
    private List<String> keywords;

}
