package com.example.kochamkino.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;



@Data
@Entity
@Table(name = "movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movieId;
    private String title;



    private float grade;
    private String genre;

    public Movie(){}

    public Movie(String title, String genre){
        this.title = title;
        this.genre = genre;
    }




}
