package com.example.kochamkino.controllers;

import com.example.kochamkino.models.Grade;
import com.example.kochamkino.models.User;
import com.example.kochamkino.repositories.GradeRepo;
import com.example.kochamkino.repositories.MovieRepo;
import com.example.kochamkino.services.GradesService;
import com.example.kochamkino.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class PagesController {

    private UserService userService;
    private GradesService gradesService;
    @Autowired
    private MovieRepo movieRepo;

    @Autowired
    private PagesController(UserService userService, GradesService gradesService) {

        this.userService = userService;
        this.gradesService = gradesService;
    }


    @GetMapping("/home")
    public String showHomePage(Model model) {
        model.addAttribute("movies", movieRepo.findAll());

        return "HomePage";
    }

    @GetMapping("/signup")
    public String signUp(Model model) {
        model.addAttribute(new User());
        return "SignUp";
    }

    @PostMapping("/register")
    public String register(User user) {
        userService.addUser(user);

        return "SignUp";
    }

    @PostMapping("/newGrade")
    public String newGrade(Grade grade){
        gradesService.addGrade(grade);

        return"HomePage";

    }

    @GetMapping("/rated")
    public String showRatedMovies(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User)authentication.getPrincipal();
        model.addAttribute("grades", gradesService.findAllUsersGrades(user));

        return "RatedMovies";
    }
}
