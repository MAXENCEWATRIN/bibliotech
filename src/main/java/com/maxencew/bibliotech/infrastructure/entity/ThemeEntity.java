package com.maxencew.bibliotech.infrastructure.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@ToString(exclude = "books")
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "THEMES")
public class ThemeEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ElementCollection
    private List<String> keywords;

    @ManyToMany(mappedBy = "themes", fetch = FetchType.EAGER)
    private List<BookEntity> books;

}
