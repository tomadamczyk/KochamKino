package com.example.kochamkino.controllers;

import com.example.kochamkino.models.Grade;
import com.example.kochamkino.models.Movie;
import com.example.kochamkino.models.User;
import com.example.kochamkino.services.GradesService;
import com.example.kochamkino.services.MovieService;
import com.example.kochamkino.services.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Generated;
import java.util.List;


@Controller
public class PagesController {

    private UserService userService;
    private MovieService movieService;
    private GradesService gradesService;

    private PagesController(UserService userService, MovieService movieService, GradesService gradesService) {

        this.userService = userService;
        this.movieService = movieService;
        this.gradesService = gradesService;
    }



    @GetMapping("/home")
    public String showHomePage() {

        //movieService.findAllMovies();
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

    @GetMapping("/rated")
    public String showRatedMovies(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User)authentication.getPrincipal();
        model.addAttribute("grades", gradesService.findAllUsersGrades(user.getUserId()));

        return "RatedMovies";
    }
}
