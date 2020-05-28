package com.example.kochamkino.services;

import com.example.kochamkino.models.Grade;
import com.example.kochamkino.models.Movie;
import com.example.kochamkino.models.User;
import com.example.kochamkino.repositories.GradeRepo;
import com.example.kochamkino.repositories.MovieRepo;
import com.example.kochamkino.repositories.UserRepo;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GradesService {

    @Autowired
    private GradeRepo gradeRepo;

    @Autowired
    private MovieRepo movieRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private UserService userService;

    public GradesService(GradeRepo gradeRepo, MovieRepo movieRepo, UserRepo userRepo, UserService userService) {
        this.gradeRepo=gradeRepo;
        this.movieRepo=movieRepo;
        this.userRepo=userRepo;
        this.userService=userService;
    }

    public List<Grade> findAllUsersGrades() {

        return gradeRepo.findByUsersId(userService.currentlyLoggedUser());

    }

    public void addGrade(Long movieId, int value){

        Movie movie = movieRepo.findByMovieId(movieId);
        User user = userService.currentlyLoggedUser();

        Grade grade = new Grade(value, user, movie);
        gradeRepo.save(grade);
    }


}
