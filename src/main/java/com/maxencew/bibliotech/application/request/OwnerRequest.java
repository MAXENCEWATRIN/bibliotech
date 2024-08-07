package com.maxencew.bibliotech.application.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class OwnerRequest {
    private Long id;
    @NotBlank(message = "FirstName is required")
    private String firstName;
    private String lastName;
    private String note;
}
