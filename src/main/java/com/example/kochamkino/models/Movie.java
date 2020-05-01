package com.example.kochamkino.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

    private String genre;

    public Movie(){}

    public Movie(String title, String genre){
        this.title = title;
        this.genre = genre;
    }

    @JsonBackReference
    @OneToOne(optional = false)
    private Grade grade;

    @JsonManagedReference
    @ManyToOne
    private Director director;

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }
}
