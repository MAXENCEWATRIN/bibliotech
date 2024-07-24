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
public class LibraryRequest {

    private Long id;
    @NotBlank(message = "Name is required")
    private String name;
    private String location;
    private Integer capacity;
}
