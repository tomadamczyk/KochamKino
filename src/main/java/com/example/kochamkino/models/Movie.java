package com.example.kochamkino.models;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "film")
public class Movie {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String director;
    private float grade;
    private String genre;

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = true)
    private User owner;

    public Movie(){}

    public Movie(String title, String director, float grade, String genre){
        this.title = title;
        this.director = director;
        this.genre = genre;
    }



}
