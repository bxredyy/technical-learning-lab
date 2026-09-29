package com.example.bookcatalog;

public class Book {

    // Each field stores one property of a book
    private Long id;
    private String title;
    private String author;
    private double price;

    // No-argument constructor, required by Spring
    public Book() {
    }

    // Constructor for creating a book with data
    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

        // Getters and setters let other code read and update each field
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
}

