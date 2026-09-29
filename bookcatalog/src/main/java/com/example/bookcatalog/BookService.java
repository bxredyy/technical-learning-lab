package com.example.bookcatalog;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    private final BookRepository bookRepository; // Database access layer

    public BookService(BookRepository bookRepository) { // Constructor injection
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() { // Returns every book from the database
        return bookRepository.findAll();
    }

    public Book getBookById(Long id) { // Throws error if book not found
        return bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found with id: " + id));
    }

    public Book createBook(Book book) { // Saves a new book to the database
        return bookRepository.save(book);
    }

    public void deleteBook(Long id) { // Removes a book by ID
        bookRepository.deleteById(id);
    }
}