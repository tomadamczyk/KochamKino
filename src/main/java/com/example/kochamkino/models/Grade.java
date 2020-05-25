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

    public Long gradeId;
    public Long usersId;
    public int value;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "movie", referencedColumnName = "movieId")
    private Movie movie;

    public Grade(){}

    public Grade(int value, Long usersId){
        this.value = value;
        this.usersId = usersId;
    }


//    @JsonManagedReference
//    @OneToOne
//    @JoinColumn(name = "movie_fk", nullable = false)
//    private Movie movie;




}
