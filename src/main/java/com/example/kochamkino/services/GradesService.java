package com.example.kochamkino.services;

import com.example.kochamkino.models.Grade;
import com.example.kochamkino.repositories.GradeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradesService {

    @Autowired
    private GradeRepo gradeRepo;

    public GradesService(GradeRepo gradeRepo) {
        this.gradeRepo=gradeRepo;
    }

    public List<Grade> findAllUsersGrades(Long userId) {
        return gradeRepo.findByUsersId(userId);
    }

    public void addGrade(Grade grade){
        gradeRepo.save(grade);
    }


}
