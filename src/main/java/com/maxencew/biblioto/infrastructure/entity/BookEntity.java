package com.maxencew.biblioto.infrastructure.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

import java.math.BigDecimal;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "BOOKS", uniqueConstraints = {@UniqueConstraint(columnNames = {"id", "isbnId"})})
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
    private ObjectId coverImageId;
    private String traductionLanguage;
    private String initialLanguage;
    private Integer firstPublishYear;
    private String firstSentence;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "editor_id")
    private EditorEntity editor;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "library_id")
    private LibraryEntity library;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "owner_id")
    private OwnerEntity owner;
    @ManyToMany(mappedBy = "books", fetch = FetchType.EAGER)
    private List<ThemeEntity> themes;
    private String overallReception;
    private String praises;
    private String criticisms;
    private Boolean isWishList;
    private Boolean isAnOpenLibaryApiRegister;
    private Boolean isAnOpenLibaryApiBookValidate;


}
