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
    @ManyToOne
    @JoinColumn(name = "director_id", nullable = false)
    private Director director;
    private float grade;
    private String genre;

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = true)
    private User owner;

    public Movie(){}

    public Movie(String title, float grade, String genre){
        this.title = title;
        this.genre = genre;
    }



}
