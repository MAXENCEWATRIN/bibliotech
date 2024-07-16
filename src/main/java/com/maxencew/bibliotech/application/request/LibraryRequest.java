package com.maxencew.bibliotech.application.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.maxencew.bibliotech.application.response.BookResponse;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
