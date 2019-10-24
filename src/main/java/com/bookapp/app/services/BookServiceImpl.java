package com.bookapp.app.services;

import com.bookapp.app.models.Book;
import com.bookapp.app.models.User;
import com.bookapp.app.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book findBookByIsbn(String isbn) {
        return bookRepository.findBookByIsbn(isbn);
    }

    @Override
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> addBooks(List<Book> books) {
        return bookRepository.saveAll(books);
    }

    @Override
    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public List<Book> findAllAvailableBooks() {
        return findAllBooks().stream().filter(book -> book.isAvailable()).collect(Collectors.toList());
    }

    @Override
    public List<Book> findAllBorrowedBooks() {
        return findAllBooks().stream().filter(book -> !book.isAvailable()).collect(Collectors.toList());
    }

    @Override
    public void deleteBook(String isbn) {
        final Book bookByIsbn = findBookByIsbn(isbn);
        if (bookByIsbn != null) {
            bookRepository.delete(bookByIsbn);
        }
    }

    @Override
    public boolean borrowBook(String isbn) {
        final Book bookByIsbn = findBookByIsbn(isbn);
        if (bookByIsbn != null && bookByIsbn.isAvailable()) {
            bookByIsbn.setAvailable(false);
            bookByIsbn.setReturnDate(getReturnDate());
            bookRepository.save(bookByIsbn);
            return true;
        }
        return false;
    }

    private LocalDate getReturnDate() {
        try {
            final SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            final Date date = formatter.parse(formatter.format(new Date()));
            final LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            return localDate.plusMonths(1);
        } catch (ParseException e) {
            System.out.println("Error parsing date: " + e.getMessage());
            return null;
        }
    }
}
