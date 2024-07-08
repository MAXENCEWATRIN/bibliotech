package com.maxencew.biblioto.application.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder(setterPrefix = "with")
public class EditorRequest {

    private String name;
    private String category;
}
