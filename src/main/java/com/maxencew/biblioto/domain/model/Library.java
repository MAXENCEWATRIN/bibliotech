package com.maxencew.biblioto.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder(setterPrefix = "with")
public class Library {

    private Long id;
    private String name;
    private String location;
    private Integer capacity;

}
