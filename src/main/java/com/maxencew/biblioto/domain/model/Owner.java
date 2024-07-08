package com.maxencew.biblioto.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
public class Owner {

    private Long id;
    private String firstName;
    private String lastName;
    private String note;
}
