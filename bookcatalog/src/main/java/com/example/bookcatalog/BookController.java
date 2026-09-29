package com.example.bookcatalog;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Tells Spring this class handles HTTP requests and returns JSON
@RestController
// All endpoints in this controller start with /api/books
@RequestMapping("/api/books")
public class BookController {

    // In-memory list to store books (no database yet)
    private final List<Book> books = new ArrayList<>();
    // Counter to give each new book a unique ID
    private Long nextId = 1L;

    // GET /api/books - returns the full list of books
    @GetMapping
    public List<Book> getAllBooks() {
        return books;
    }

    // GET /api/books/{id} - finds one book by its ID
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return books.stream()
                .filter(b -> b.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    // POST /api/books - creates a new book from JSON in the request body
    @PostMapping
    public Book createBook(@RequestBody Book book) {
        book.setId(nextId++);
        books.add(book);
        return book;
    }


}