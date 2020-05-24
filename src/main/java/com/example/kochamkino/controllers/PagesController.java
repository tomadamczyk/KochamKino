package com.example.kochamkino.controllers;

import com.example.kochamkino.models.User;
import com.example.kochamkino.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@Controller
public class PagesController {

    private UserService userService;

    private PagesController(UserService userService) {
        this.userService=userService;
    }


    @GetMapping("/home")
    public String showHomePage() {





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
