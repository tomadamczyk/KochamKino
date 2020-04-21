package com.example.kochamkino.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "użytkownik")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String firstName;
    private String lastName;
    private char sex;
    private String email;
    private String login;
    private String password;

    @JsonBackReference
    @ManyToMany
    private Set<Movie> ownedMovies;


    public User(){}

    public User(String firstName, String lastName, char sex, String email, String login, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.email = email;
        this.login = login;
        this.password = password;
    }
}
