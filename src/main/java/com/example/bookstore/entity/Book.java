package com.example.bookstore.entity;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "books") // This will create a table named 'books'
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generate primary key values
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String author;
    @Column(name = "`year`") // Use backticks to escape the keyword
    private int year;

    private double rating; // Stores the average rating

    @Column(columnDefinition = "TEXT")
    private String description; // Additional field for storing book description

    // Default constructor (required by JPA)
    public Book() {
    }

    // Constructor
    public Book(String title, String author, int year, double rating, String description) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.rating = rating;
        this.description = description;
    }

    // Getters and setters
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Overriding equals and hashCode (useful for collections and comparisons)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return year == book.year &&
                Double.compare(book.rating, rating) == 0 &&
                Objects.equals(id, book.id) &&
                Objects.equals(title, book.title) &&
                Objects.equals(author, book.author) &&
                Objects.equals(description, book.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, author, year, rating, description);
    }
}
