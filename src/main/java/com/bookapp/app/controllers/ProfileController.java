package com.bookapp.app.controllers;

import com.bookapp.app.constant.Constants;
import com.bookapp.app.services.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("username")
public class ProfileController {

    private UserService userService;

    public ProfileController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/profile")
    public String showProfileInfo(final ModelMap modelMap) {
        final String loggedInUser = getLoggedInUser();
        if (loggedInUser != null && !loggedInUser.equals(Constants.ANONYMOUS_USER)) {
            modelMap.put("user", userService.findByUsername(loggedInUser));
            return "profile";
        } else {
            return "login";
        }
    }

    private String getLoggedInUser() {
        final Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return (principal instanceof UserDetails) ? ((UserDetails) principal).getUsername() : principal.toString();
    }
}