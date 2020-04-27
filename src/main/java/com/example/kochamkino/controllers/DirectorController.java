package com.example.kochamkino.controllers;


import com.example.kochamkino.repositories.DirectorRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity listDirectors(){return new ResponseEntity(directorRepo.findAll(), HttpStatus.ACCEPTED);}
}
