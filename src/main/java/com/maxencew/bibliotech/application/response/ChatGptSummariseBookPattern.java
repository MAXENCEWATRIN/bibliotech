package com.maxencew.bibliotech.application.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChatGptSummariseBookPattern {

    private String title;
    private String author;
    private String summary;
    private String synopsis;
    private PublicOpinions publicOpinions;


    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class PublicOpinions {
        @JsonProperty("overallReception")
        private String overallReception;
        @JsonProperty("praises")
        private String praises;
        @JsonProperty("criticisms")
        private String criticisms;
    }
}
