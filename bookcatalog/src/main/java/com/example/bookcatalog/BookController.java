package com.example.bookcatalog;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService; // Service layer handles logic

    // Spring injects BookService automatically
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

        @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // Returns 201 status for new resources
    public Book createBook(@Valid @RequestBody Book book) {
        return bookService.createBook(book);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // Returns 204 status after deletion
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }

    // Search for books by title or author
    @GetMapping("/search")
    public List<Book> searchBooks(@RequestParam(required = false) String title,
                                  @RequestParam(required = false) String author) {
        if (title != null) {
            return bookService.searchByTitle(title);
        } else if (author != null) {
            return bookService.searchByAuthor(author);
        }
        return bookService.getAllBooks();
    }
}