package com.maxencew.biblioto.application.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder(setterPrefix = "with")
public class EditorResponse {

    private String name;
    private String category;
}
