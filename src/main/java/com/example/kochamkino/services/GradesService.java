package com.example.kochamkino.services;

import com.example.kochamkino.models.Grade;
import com.example.kochamkino.models.Movie;
import com.example.kochamkino.models.User;
import com.example.kochamkino.repositories.GradeRepo;
import com.example.kochamkino.repositories.MovieRepo;
import com.example.kochamkino.repositories.UserRepo;
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

    public GradesService(GradeRepo gradeRepo, MovieRepo movieRepo, UserRepo userRepo) {
        this.gradeRepo=gradeRepo;
        this.movieRepo=movieRepo;
        this.userRepo=userRepo;
    }

    public List<Grade> findAllUsersGrades(User user) {
        return gradeRepo.findByUsersId(user);
    }

    public void addGrade(Long movieId, int value){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User)authentication.getPrincipal();
        Movie movie = movieRepo.findByMovieId(movieId);

        Grade grade = new Grade(value, user, movie);
        gradeRepo.save(grade);
    }


}
