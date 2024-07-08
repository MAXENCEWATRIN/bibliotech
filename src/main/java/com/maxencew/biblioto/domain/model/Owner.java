package com.maxencew.biblioto.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder(setterPrefix = "with")
public class Owner {

    private String firstName;
    private String lastName;
    private String note;
}
