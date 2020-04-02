package com.example.kochamkino.controllers;


import com.example.kochamkino.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/uzytkownicy")
public class UserController {

    @Autowired
    private final UserRepo userRepo;


    public UserController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping
    public ResponseEntity listUsers() { return new ResponseEntity(userRepo.findAll(), HttpStatus.ACCEPTED);}
}
