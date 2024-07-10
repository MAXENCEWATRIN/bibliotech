package com.maxencew.biblioto.application.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class EditorRequest {

    private Long id;
    private String name;
    private String category;
    private String edition;
}
