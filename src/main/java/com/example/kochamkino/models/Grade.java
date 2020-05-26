package com.example.kochamkino.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "grade")
public class Grade implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gradeId;

    @JsonManagedReference
    @OneToOne
    public User usersId;
    public int value;

    @JsonManagedReference
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "movie", referencedColumnName = "movieId")
    private Movie movie;

    public Grade(){}

    public Grade(int value, User users, Movie movie){
        this.value = value;
        this.usersId = users;
        this.movie = movie;

    }


//    @JsonManagedReference
//    @OneToOne
//    @JoinColumn(name = "movie_fk", nullable = false)
//    private Movie movie;




}
