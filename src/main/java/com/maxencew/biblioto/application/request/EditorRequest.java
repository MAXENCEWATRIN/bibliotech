package com.maxencew.biblioto.application.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
public class EditorRequest {

    private Long id;
    private String name;
    private String category;
}
