package com.example.kochamkino.repositories;

import com.example.kochamkino.models.Director;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DirectorRepo extends JpaRepository<Director, Long> {
}
