package com.example.kochamkino.service;

public interface SecurityService {
    String findLoggedInUsername();

    void autoLogin(String username, String password);
}