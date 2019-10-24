package com.bookapp.app.controllers;

import com.bookapp.app.constant.Constants;
import com.bookapp.app.models.Author;
import com.bookapp.app.services.AuthorService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("username")
public class AuthorController {

    private AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping(value = "/add-author")
    public String addBookView(ModelMap modelMap, final Author author) {
        if (getLoggedInUser() != null && getLoggedInUser() != Constants.ANONYMOUS_USER) {
            final Author newAuthor = new Author();
            modelMap.addAttribute("newAuthor", newAuthor);
            return "add-author";
        } else {
            return "redirect:/login";
        }
    }

    @PostMapping(value = "/add-author")
    public String addBook(ModelMap modelMap, final Author author) {
        if (getLoggedInUser() != null && getLoggedInUser() != Constants.ANONYMOUS_USER) {
            final Author authorToAdd = authorService.addAuthor(author);
            modelMap.addAttribute("authorToAdd", authorToAdd);
            return "author-add-success";
        } else {
            return "redirect:/login";
        }
    }

    private String getLoggedInUser() {
        final Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return (principal instanceof UserDetails) ? ((UserDetails) principal).getUsername() : principal.toString();
    }

}
