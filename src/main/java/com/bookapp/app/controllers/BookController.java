package com.bookapp.app.controllers;

import com.bookapp.app.constant.Constants;
import com.bookapp.app.models.Author;
import com.bookapp.app.models.Book;
import com.bookapp.app.models.Categories;
import com.bookapp.app.services.AuthorService;
import com.bookapp.app.services.BookService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Controller
@SessionAttributes("username")
public class BookController {

    private BookService bookService;
    private AuthorService authorService;

    public BookController(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @GetMapping("")
    public String findBookByIsbn(String isbn) {
        return null;
    }

    public String findAllBooks() {
        return null;
    }

    @GetMapping("/available-books")
    public String findAllAvailableBooks(final ModelMap modelMap) {
        if (getLoggedInUser() != null && getLoggedInUser() != Constants.ANONYMOUS_USER) {
            final List<Book> availableBooks = bookService.findAllAvailableBooks();
            modelMap.addAttribute("availableBooks", availableBooks);
            return "availableBooks";
        } else {
            return "redirect:/login";
        }
    }

    @GetMapping("/borrowed-books")
    public String findAllBorrowedBooks(final ModelMap modelMap) {
        if (getLoggedInUser() != null && getLoggedInUser() != Constants.ANONYMOUS_USER) {
            final List<Book> borrowedBooks = bookService.findAllBorrowedBooks();
            modelMap.addAttribute("borrowedBooks", borrowedBooks);
            return "borrowedBooks";
        } else {
            return "redirect:/login";
        }
    }

    @GetMapping(value = "/all-books")
    public String findAllBooks(ModelMap modelMap) {
        if (getLoggedInUser() != null && getLoggedInUser() != Constants.ANONYMOUS_USER) {
            final List<Book> allBooks = bookService.findAllBooks();
            modelMap.addAttribute("allBooks", allBooks);
            return "all-books";
        } else {
            return "redirect:/login";
        }
    }

    @GetMapping(value = "/add-book")
    public String addBookView(ModelMap modelMap) {
        if (getLoggedInUser() != null && getLoggedInUser() != Constants.ANONYMOUS_USER) {
            final Book bookToAdd = new Book();
            final List<Author> authors = authorService.findAllAuthors();
            modelMap.addAttribute("categories", Categories.getDescriptions());
            modelMap.addAttribute("authors", authors);
            modelMap.addAttribute("bookToAdd", bookToAdd);
            return "add-book";
        } else {
            return "redirect:/login";
        }
    }

    @PostMapping(value = "/add-book")
    public String addBook(ModelMap modelMap, final Book book) {
        if (getLoggedInUser() != null && getLoggedInUser() != Constants.ANONYMOUS_USER) {
            final Book bookToAdd = bookService.addBook(book);
            modelMap.addAttribute("bookToAdd", bookToAdd);
            return "redirect:/all-books";
        } else {
            return "redirect:/login";
        }
    }

    @GetMapping("/delete-book/{isbn}")
    public String deleteBook(final ModelMap modelMap, @PathVariable final String isbn) throws Exception {
        if (getLoggedInUser() != null && getLoggedInUser() != Constants.ANONYMOUS_USER) {
            final Book bookToDelete = bookService.findBookByIsbn(isbn);
            modelMap.addAttribute("bookToDelete", bookToDelete);
            if (bookToDelete != null) {
                bookService.deleteBook(isbn);
            }
            return "delete-book-success";
        } else {
            return "redirect:/login";
        }
    }

    @GetMapping("/borrow-book/{isbn}")
    public String borrowBook(final ModelMap modelMap, @PathVariable final String isbn) {
        if (getLoggedInUser() != null && getLoggedInUser() != Constants.ANONYMOUS_USER) {
            final boolean isAvailable = bookService.borrowBook(isbn);
            if (isAvailable) {
                modelMap.addAttribute("bookByIsbn", bookService.findBookByIsbn(isbn));
                return "borrow-book-success";
            } else {
                return "borrow-book-failure";
            }
        } else {
            return "redirect:/login";
        }
    }

    @GetMapping("/return-book/{isbn}")
    public String returnBook(@PathVariable final String isbn, final ModelMap modelMap) {
        final boolean isReturned = bookService.returnBook(isbn);
        if (isReturned) {
            modelMap.addAttribute("returnedBook", bookService.findBookByIsbn(isbn));
        }
        return "return-book-success";
    }

    private String getLoggedInUser() {
        final Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return (principal instanceof UserDetails) ? ((UserDetails) principal).getUsername() : principal.toString();
    }

}
