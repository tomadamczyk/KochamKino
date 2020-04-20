package com.example.kochamkino.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.Collections;
import java.util.Set;

@Data
@Entity
@Table(name = "film")
public class Movie {

    @Id
    @GeneratedValue
    private Long id;
    private String title;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "director_fk", nullable = true)
    private Director director;
    private float grade;
    private String genre;

    @JsonManagedReference
    @ManyToMany
    private Set<User> owners = Collections.emptySet();

    public Movie(){}

    public Movie(String title, String genre){
        this.title = title;
        this.genre = genre;
    }




}
