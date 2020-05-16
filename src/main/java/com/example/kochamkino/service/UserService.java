package com.example.kochamkino.service;

import com.example.kochamkino.models.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}