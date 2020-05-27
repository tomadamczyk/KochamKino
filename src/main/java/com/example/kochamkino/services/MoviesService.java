package com.example.kochamkino.services;

import com.example.kochamkino.models.Grade;
import com.example.kochamkino.models.Movie;
import com.example.kochamkino.models.User;
import com.example.kochamkino.repositories.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoviesService {

    @Autowired
    private MovieRepo movieRepo;

    public List<Movie> findAllMovies() {
        return movieRepo.findAll();
    }
}
