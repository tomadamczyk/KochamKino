package com.example.kochamkino.repositories;

import com.example.kochamkino.models.Move;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoveRepo extends JpaRepository<Move, Long> {
}
