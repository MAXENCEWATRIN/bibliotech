package com.maxencew.biblioto.application.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OwnerResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String note;
    private List<BookResponse> books;
}
