package com.example.kochamkino.services;


import com.example.kochamkino.dtos.MovieDto;
import com.example.kochamkino.models.Movie;
import com.example.kochamkino.repositories.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.emptyList;

@Service
public class MovieService {

    @Autowired
    MovieRepo movieRepo;

    public List<MovieDto> findAllMovies(){
        List<MovieDto> movies = new ArrayList<>();

        for (Movie movie : movieRepo.findAll()){
            movies.add(new MovieDto(movie.getMovieId(), movie.getTitle(),movie.getGrade(), movie.getGenre()));
        }

        System.out.print(movies);
        return movies;
    }



}
