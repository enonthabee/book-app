package com.bookapp.app.services;

public interface SecurityService {
    String findLoggedInUsername();

    void autoLogin(String username, String password);
}

