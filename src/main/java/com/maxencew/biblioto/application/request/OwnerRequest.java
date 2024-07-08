package com.maxencew.biblioto.application.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OwnerRequest {
    private Long id;
    private String firstName;
    private String lastName;
    private String note;
}
