package com.example.kochamkino.controllers;

import com.example.kochamkino.models.Movie;
import com.example.kochamkino.models.User;
import com.example.kochamkino.services.MovieService;
import com.example.kochamkino.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@Controller
public class PagesController {

    private UserService userService;
    private MovieService movieService;

    private PagesController(UserService userService, MovieService movieService) {

        this.userService = userService;
        this.movieService = movieService;
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

}
