package com.example.bookcatalog;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

    // Find books whose title contains the search term (case-insensitive)
    List<Book> findByTitleContainingIgnoreCase(String title);

    // Find books whose author contains the search term (case-insensitive)
    List<Book> findByAuthorContainingIgnoreCase(String author);
}