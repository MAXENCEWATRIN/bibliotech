package com.maxencew.bibliotech.application.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OwnerResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String note;
}
