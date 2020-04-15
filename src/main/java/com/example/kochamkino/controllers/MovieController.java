package com.example.kochamkino.controllers;


import com.example.kochamkino.repositories.MovieRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/filmy")
public class MovieController {

    private final MovieRepo movieRepo;


    public MovieController(MovieRepo movieRepo){this.movieRepo = movieRepo;}

    @GetMapping
    public ResponseEntity listMovies() { return new ResponseEntity(movieRepo.findAll(), HttpStatus.ACCEPTED);}




}
