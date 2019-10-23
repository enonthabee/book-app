package com.bookapp.app;

import com.bookapp.app.models.*;
import com.bookapp.app.services.AuthorService;
import com.bookapp.app.services.BookService;
import com.bookapp.app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class BookApplication implements CommandLineRunner {

    @Autowired
    private UserService userService;

    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorService authorService;

    public static void main(String[] args) {
        SpringApplication.run(BookApplication.class, args);
    }

    @Override
    public void run(String... args) {
        User user = new User();
        user.setName("Nthabiseng");
        user.setSurname("Ratau");
        user.setEmail("rataunq@gmail.com");
        user.setUsername("rataunq@gmail.com");
        user.setPassword("1234");
        user.setGender("Female");
        user.setCellNo("0721245687");

        authorService.addAuthor(getAuthors().get(1)); // Adding Lindiswizwe to authors table
        userService.addUser(user);
        bookService.addBooks(getBooks());
    }

    private static List<Book> getBooks() {
        final List<Book> books = new ArrayList<>();

        final Book book = new Book();
        book.setIsbn("123456789");
        book.setAvailable(true);
        book.setTitle("How to train a dragon");
        book.setAuthor(getAuthors().get(0));  // Assigning Mmabatho as a writer to book (How to train a dragon)
        book.setCategory(Categories.KIDS.getDescription());
        books.add(book);

        return books;
    }

    private static List<Author> getAuthors() {
        final List<Author> authors = new ArrayList<>();
        final Author mmabatho = new Author();
        mmabatho.setName("Mmabatho");
        mmabatho.setSurname("Magakwe");

        final Author lindisizwe = new Author();
        lindisizwe.setName("Lindisizwe");
        lindisizwe.setSurname("Makaula");

        authors.add(mmabatho);
        authors.add(lindisizwe);
        return authors;
    }

    private static List<Category> getCategories() {
        final List<Category> categories = new ArrayList<>();
        categories.add(new Category(Categories.KIDS.getDescription()));
        categories.add(new Category(Categories.THRILLER.getDescription()));
        categories.add(new Category(Categories.HORROR.getDescription()));
        categories.add(new Category(Categories.SCIENCE_FICTION.getDescription()));
        return categories;
    }
}
