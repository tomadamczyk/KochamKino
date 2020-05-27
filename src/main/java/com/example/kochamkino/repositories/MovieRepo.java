package com.example.kochamkino.repositories;

import com.example.kochamkino.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepo extends JpaRepository<Movie, Long> {

    @Override
    List<Movie> findAll();
    Movie findByMovieId(Long movieId);
}
