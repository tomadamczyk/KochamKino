package com.example.kochamkino.repositories;

import com.example.kochamkino.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepo extends JpaRepository<Movie, Long> {
}
