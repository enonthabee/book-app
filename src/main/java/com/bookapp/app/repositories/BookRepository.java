package com.bookapp.app.repositories;

import com.bookapp.app.models.Book;
import com.bookapp.app.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, String> {
    Book findBookByIsbn(String isbn);
}
