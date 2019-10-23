package com.bookapp.app.controllers;

import com.bookapp.app.models.User;
import com.bookapp.app.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    private UserService userService;
    private static final String REGISTER_USER_VIEW = "sign-up";

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String showRegisterUserPage(ModelMap model) {
        model.addAttribute("user", new User());
        return REGISTER_USER_VIEW;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerUser(ModelMap modelMap, @Valid User user, BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()) {
            return REGISTER_USER_VIEW;
        }
        userService.addUser(user);
        modelMap.put("user", user);
        modelMap.put("username", user.getUsername());
        return "redirect:/login";
    }
}
