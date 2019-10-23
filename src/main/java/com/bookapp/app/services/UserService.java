package com.bookapp.app.services;

import com.bookapp.app.models.User;

import java.util.List;

public interface UserService {
    User addUser(User user);
    User getUser(Long id) throws Exception;
    User findByUsername(String username);
    List<User> getUsers();
    void deleteUser(Long id) throws Exception;
}
