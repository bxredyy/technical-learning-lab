package com.example.bookcatalog;

import org.springframework.data.jpa.repository.JpaRepository;

// Extends JpaRepository to get save, findAll, findById, deleteById for free
public interface BookRepository extends JpaRepository<Book, Long> {
}