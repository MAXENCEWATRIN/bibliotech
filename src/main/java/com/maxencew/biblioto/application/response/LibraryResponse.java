package com.maxencew.biblioto.application.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class LibraryResponse {

    private Long id;
    private String name;
    private String location;
    private Integer capacity;
    private List<BookResponse> books;


}
