package com.example.kochamkino.controllers;


import com.example.kochamkino.repositories.MovieRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieRepo movieRepo;


    public MovieController(MovieRepo movieRepo){this.movieRepo = movieRepo;}


    @GetMapping("/movies")
    public String getAllMovies(Model model){
        Iterable movies = movieRepo.findAll();
        model.addAttribute("movies", movies);

        return "AllMovies";
    }




    @GetMapping
    public ResponseEntity listMovies() { return new ResponseEntity(movieRepo.findAll(), HttpStatus.ACCEPTED);}


}
