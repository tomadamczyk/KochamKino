package com.example.kochamkino.repositories;

import com.example.kochamkino.models.Director;
import com.example.kochamkino.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepo extends JpaRepository<Movie, Long> {

    @Override
    List<Movie> findAll();
    List<Movie> findByGenre(String genre);
    List<Movie> findByDirector(Director director);
    Movie findByMovieId(Long movieId);

}
