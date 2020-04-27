package com.example.kochamkino.models;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "grade")
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gradeId;

    private int value;

    public Grade(){}

    public Grade(int value){
        this.value = value;
    }


//    @JsonManagedReference
//    @OneToOne
//    @JoinColumn(name = "movie_fk", nullable = false)
//    private Movie movie;




}
