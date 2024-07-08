package com.maxencew.biblioto.application.request;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@Builder(setterPrefix = "with")
public class ThemeRequest {

    private Long id;
    private String name;
    private List<String> keywords;

}
