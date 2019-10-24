package com.bookapp.app.services;

import com.bookapp.app.models.Book;

import java.util.List;

public interface BookService {
    Book findBookByIsbn(String isbn);
    Book addBook(Book book);
    List<Book> addBooks(List<Book> books);
    List<Book> findAllBooks();
    List<Book> findAllAvailableBooks();
    List<Book> findAllBorrowedBooks();
    void deleteBook(String isbn) throws Exception;
    boolean borrowBook(String isbn);
    boolean returnBook(String isbn);
}
