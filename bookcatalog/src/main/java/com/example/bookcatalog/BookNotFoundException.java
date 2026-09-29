package com.example.bookcatalog;

// Custom exception for when a book ID does not exist
public class BookNotFoundException extends RuntimeException {

    public BookNotFoundException(Long id) {
        super("Book not found with id: " + id);
    }
}