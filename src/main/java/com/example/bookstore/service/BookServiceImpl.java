package com.example.bookstore.service;

import com.example.bookstore.entity.Book;
import com.example.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public List<Book> getAllBooks(String title, String author, Integer year, Double minRating) {
        if (title != null) {
            return findBooksByTitle(title);
        }
        if (author != null) {
            return findBooksByAuthor(author);
        }
        if (year != null) {
            return findBooksByYear(year);
        }
        if (minRating != null) {
            return findBooksByRating(minRating);
        }
        return bookRepository.findAll();
    }

    @Override
    public Book updateBook(Long id, Book bookDetails) {
        return bookRepository.findById(id).map(book -> {
            book.setTitle(bookDetails.getTitle());
            book.setAuthor(bookDetails.getAuthor());
            book.setYear(bookDetails.getYear());
            book.setRating(bookDetails.getRating());
            book.setDescription(bookDetails.getDescription());
            return bookRepository.save(book);
        }).orElse(null);  // Return null instead of throwing an exception
    }

    @Override
    public boolean deleteBook(Long id) {
        if (!bookRepository.existsById(id)) {
            return false; // Simply return false if the book does not exist
        }
        bookRepository.deleteById(id);
        return true;
    }

    @Override
    public List<Book> findBooksByTitle(String title) {
        return bookRepository.findByTitleContainingIgnoreCase(title);
    }

    @Override
    public List<Book> findBooksByAuthor(String author) {
        return bookRepository.findByAuthorContainingIgnoreCase(author);
    }

    @Override
    public List<Book> findBooksByYear(int year) {
        return bookRepository.findByYear(year);
    }

    @Override
    public List<Book> findBooksByRating(double rating) {
        return bookRepository.findByRatingGreaterThanEqual(rating);
    }

    @Override
    public Book rateBook(Long id, double newRating) {
        return bookRepository.findById(id).map(book -> {
            double currentRating = book.getRating();
            double updatedRating = (currentRating + newRating) / 2; // Average the current and new rating
            book.setRating(updatedRating);
            return bookRepository.save(book);
        }).orElse(null); // Return null if book is not found
    }
}
