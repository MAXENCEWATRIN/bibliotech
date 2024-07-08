package com.maxencew.biblioto.application.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data

@AllArgsConstructor
public class BookResponse {
    private Long id;
    private String name;
    private String location;
    private Integer capacity;


}
