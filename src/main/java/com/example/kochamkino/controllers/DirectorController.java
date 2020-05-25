package com.example.kochamkino.controllers;


import com.example.kochamkino.models.User;
import com.example.kochamkino.repositories.DirectorRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/directors")
public class DirectorController {
    private final DirectorRepo directorRepo;


    public DirectorController(DirectorRepo directorRepo) {
        this.directorRepo = directorRepo;
    }

    @GetMapping
    public String showId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User)authentication.getPrincipal();
        return String.valueOf(user.getUserId());
    }
    //public ResponseEntity listDirectors(){return new ResponseEntity(directorRepo.findAll(), HttpStatus.ACCEPTED);}


}
