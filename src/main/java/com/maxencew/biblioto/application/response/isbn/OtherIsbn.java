package com.maxencew.biblioto.application.response.isbn;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OtherIsbn {
    private String isbn;
    private String binding;
}