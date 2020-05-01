package com.example.kochamkino.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "directors")
@Data
public class Director{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long directorId;

    private String firstName;
    private String lastName;



    public Director(){}

    public Director(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @JsonBackReference
    @OneToMany(mappedBy = "director")
    private Collection<Movie> movies = new LinkedList<>();

    public Collection<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Collection<Movie> movies) {
        this.movies = movies;
    }


    public void addMovie(Movie movie){
        this.movies.add(movie);
    }
}
