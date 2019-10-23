package com.bookapp.app.services;

import com.bookapp.app.models.Author;

import java.util.List;

public interface AuthorService {
    Author addAuthor(Author author);
    List<Author> findAllAuthors();
}
