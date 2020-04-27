package com.example.kochamkino.repositories;

import com.example.kochamkino.models.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GradeRepo extends JpaRepository<Grade, Long> {
}
