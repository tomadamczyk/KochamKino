package com.example.kochamkino.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;


@Data
@Entity
@Table(name = "movie")
public class Movie implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonBackReference
    private Long movieId;
    private String title;
    private int releaseYear;

    @ManyToOne(optional = false)
    private Director director;




    private float grade;
    private String genre;

    public Movie(){}

    public Movie(String title, String genre, Director director, int releaseYear){
        this.title = title;
        this.genre = genre;
        this.director = director;
        this.releaseYear = releaseYear;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }


    public Director getDirector() {
        return director;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setDirector(Director director) {
        this.director = director;
    }
}
