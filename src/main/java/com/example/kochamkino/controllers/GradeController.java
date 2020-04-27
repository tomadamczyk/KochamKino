package com.example.kochamkino.controllers;


import com.example.kochamkino.repositories.GradeRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/grades")
public class GradeController {

    private final GradeRepo gradeRepo;


    public GradeController(GradeRepo gradeRepo){ this.gradeRepo = gradeRepo;}

    @GetMapping
    public ResponseEntity listGrades(){
        return new ResponseEntity(gradeRepo.findAll(), HttpStatus.ACCEPTED);
    }


}
