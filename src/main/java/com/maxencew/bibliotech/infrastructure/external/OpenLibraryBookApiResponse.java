package com.maxencew.bibliotech.infrastructure.external;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Map;

@lombok.Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenLibraryBookApiResponse {

    @JsonProperty("records")
    private Map<String, Record> records;

    @JsonProperty("items")
    private List<Item> items;

    @lombok.Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Record {
        @JsonProperty("isbns")
        private List<String> isbns;

        @JsonProperty("issns")
        private List<String> issns;

        @JsonProperty("lccns")
        private List<String> lccns;

        @JsonProperty("oclcs")
        private List<String> oclcs;

        @JsonProperty("olids")
        private List<String> olids;

        @JsonProperty("publishDates")
        private List<String> publishDates;

        @JsonProperty("recordURL")
        private String recordURL;

        @JsonProperty("data")
        private Data data;

        @JsonProperty("details")
        private Details details;
    }

    @lombok.Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Data {
        @JsonProperty("url")
        private String url;

        @JsonProperty("key")
        private String key;

        @JsonProperty("title")
        private String title;

        @JsonProperty("authors")
        private List<Author> authors;

        @JsonProperty("number_of_pages")
        private int numberOfPages;

        @JsonProperty("identifiers")
        private Identifiers identifiers;

        @JsonProperty("classifications")
        private Classifications classifications;

        @JsonProperty("publishers")
        private List<Publisher> publishers;

        @JsonProperty("publish_date")
        private String publishDate;

        @JsonProperty("subjects")
        private List<Subject> subjects;

        @JsonProperty("subject_places")
        private List<SubjectPlace> subjectPlaces;

        @JsonProperty("subject_people")
        private List<SubjectPerson> subjectPeople;

        @JsonProperty("subject_times")
        private List<SubjectTime> subjectTimes;

        @JsonProperty("excerpts")
        private List<Excerpt> excerpts;

        @JsonProperty("links")
        private List<Link> links;

        @JsonProperty("cover")
        private Cover cover;
    }

    @lombok.Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Author {
        @JsonProperty("url")
        private String url;

        @JsonProperty("name")
        private String name;
    }

    @lombok.Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Identifiers {
        @JsonProperty("amazon")
        private List<String> amazon;

        @JsonProperty("isbn_10")
        private List<String> isbn10;

        @JsonProperty("isbn_13")
        private List<String> isbn13;

        @JsonProperty("openlibrary")
        private List<String> openlibrary;
    }

    @lombok.Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Classifications {
        @JsonProperty("lc_classifications")
        private List<String> lcClassifications;
    }

    @lombok.Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Publisher {
        @JsonProperty("name")
        private String name;
    }

    @lombok.Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Subject {
        @JsonProperty("name")
        private String name;

        @JsonProperty("url")
        private String url;
    }

    @lombok.Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class SubjectPlace {
        @JsonProperty("name")
        private String name;

        @JsonProperty("url")
        private String url;
    }

    @lombok.Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class SubjectPerson {
        @JsonProperty("name")
        private String name;

        @JsonProperty("url")
        private String url;
    }

    @lombok.Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class SubjectTime {
        @JsonProperty("name")
        private String name;

        @JsonProperty("url")
        private String url;
    }

    @lombok.Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Excerpt {
        @JsonProperty("text")
        private String text;

        @JsonProperty("comment")
        private String comment;

        @JsonProperty("first_sentence")
        private boolean firstSentence;
    }

    @lombok.Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Link {
        @JsonProperty("title")
        private String title;

        @JsonProperty("url")
        private String url;
    }

    @lombok.Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Cover {
        @JsonProperty("small")
        private String small;

        @JsonProperty("medium")
        private String medium;

        @JsonProperty("large")
        private String large;
    }

    @lombok.Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Details {
        @JsonProperty("bib_key")
        private String bibKey;

        @JsonProperty("info_url")
        private String infoUrl;

        @JsonProperty("preview")
        private String preview;

        @JsonProperty("preview_url")
        private String previewUrl;

        @JsonProperty("thumbnail_url")
        private String thumbnailUrl;

        @JsonProperty("details")
        private DetailsData detailsData;
    }

    @lombok.Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class DetailsData {
        @JsonProperty("publishers")
        private List<String> publishers;

        @JsonProperty("identifiers")
        private Identifiers identifiers;

        @JsonProperty("covers")
        private List<Integer> covers;

        @JsonProperty("physical_format")
        private String physicalFormat;

        @JsonProperty("full_title")
        private String fullTitle;

        @JsonProperty("lc_classifications")
        private List<String> lcClassifications;

        @JsonProperty("key")
        private String key;

        @JsonProperty("authors")
        private List<Author> authors;

        @JsonProperty("source_records")
        private List<String> sourceRecords;

        @JsonProperty("title")
        private String title;

        @JsonProperty("number_of_pages")
        private int numberOfPages;

        @JsonProperty("isbn_13")
        private List<String> isbn13;

        @JsonProperty("isbn_10")
        private List<String> isbn10;

        @JsonProperty("publish_date")
        private String publishDate;

        @JsonProperty("works")
        private List<Work> works;

        @JsonProperty("type")
        private Type type;

        @JsonProperty("latest_revision")
        private int latestRevision;

        @JsonProperty("revision")
        private int revision;

        @JsonProperty("created")
        private Datetime created;

        @JsonProperty("last_modified")
        private Datetime lastModified;
    }

    @lombok.Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Work {
        @JsonProperty("key")
        private String key;
    }

    @lombok.Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Type {
        @JsonProperty("key")
        private String key;
    }

    @lombok.Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Datetime {
        @JsonProperty("type")
        private String type;

        @JsonProperty("value")
        private String value;
    }

    @lombok.Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Item {
        @JsonProperty("enumcron")
        private boolean enumcron;

        @JsonProperty("match")
        private String match;

        @JsonProperty("status")
        private String status;

        @JsonProperty("fromRecord")
        private String fromRecord;

        @JsonProperty("ol-edition-id")
        private String olEditionId;

        @JsonProperty("ol-work-id")
        private String olWorkId;

        @JsonProperty("publishDate")
        private String publishDate;

        @JsonProperty("contributor")
        private String contributor;

        @JsonProperty("itemURL")
        private String itemURL;

        @JsonProperty("cover")
        private Cover cover;
    }
}
