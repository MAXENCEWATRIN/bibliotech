package com.maxencew.biblioto.infrastructure.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "BOOKS")
public class BookEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(precision = 13)
    private BigDecimal isbnId;
    @Column(precision = 10)
    private BigDecimal oldIsbnId;
    private String title;
    private String authorName;
    private String titleLong;
    private String subtitle;
    private String synopsis;
    private String summary;
    private Integer numberOfPage;
    private String openLibraryId;
    private String coverPageUrl;
    private String traductionLanguage;
    private String initialLanguage;
    private Integer firstPublishYear;
    private String firstSentence;
    @ManyToOne
    @JoinColumn(name = "editor_id")
    private EditorEntity editor;
    @ManyToOne
    @JoinColumn(name = "library_id")
    private LibraryEntity library;
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private OwnerEntity owner;
    @ManyToMany(mappedBy = "books")
    private List<ThemeEntity> themes;
    private Boolean isWishLists;
    private Boolean isAnOpenLibaryApiRegister;
    private Boolean isAnOpenLibaryApiBookValidate;


}
