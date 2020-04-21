package com.example.kochamkino.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;

import java.util.LinkedList;
import java.util.List;


@Data
@Entity
@Table(name = "film")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movieId;
    private String title;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "director_fk", nullable = true)
    private Director director;
    private float grade;
    private String genre;

    @JsonManagedReference
    @ManyToMany
    private List<User> owners = new LinkedList<User>();

    public Movie(){}

    public Movie(String title, String genre){
        this.title = title;
        this.genre = genre;
    }
     public void addOwner(User owner){
        this.owners.add(owner);
     }



}
