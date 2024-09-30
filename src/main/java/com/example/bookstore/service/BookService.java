package com.example.bookstore.service;

import com.example.bookstore.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    Book saveBook(Book book);
    Optional<Book> getBookById(Long id);
    List<Book> getAllBooks(String title, String author, Integer year, Double minRating);
    Book updateBook(Long id, Book bookDetails);
    boolean deleteBook(Long id);
    List<Book> findBooksByTitle(String title);
    List<Book> findBooksByAuthor(String author);
    List<Book> findBooksByYear(int year);
    List<Book> findBooksByRating(double rating);
    Book rateBook(Long id, double newRating);
}
