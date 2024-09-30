package com.example.bookstore.repository;

import com.example.bookstore.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    // Method to find books by title, ignoring case
    List<Book> findByTitleContainingIgnoreCase(String title);

    // Other query methods can be added here
    List<Book> findByAuthorContainingIgnoreCase(String author);
    List<Book> findByYear(int year);
    List<Book> findByRatingGreaterThanEqual(double rating);
}
