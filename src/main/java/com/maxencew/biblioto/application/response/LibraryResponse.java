package com.maxencew.biblioto.application.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(setterPrefix = "with")
public class LibraryResponse {

    private Long id;
    private String name;
    private String location;
    private Integer capacity;



}
