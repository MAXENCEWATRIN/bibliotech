package com.maxencew.bibliotech.infrastructure.repository;

import com.maxencew.bibliotech.infrastructure.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {
    BookEntity getBookByIsbnId(final Long isbnId);
}
