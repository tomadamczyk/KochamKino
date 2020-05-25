package com.example.kochamkino.repositories;

import com.example.kochamkino.models.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GradeRepo extends JpaRepository<Grade, Long> {
    List<Grade> findByUsersId(Long usersId);
}
