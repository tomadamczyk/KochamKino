package com.example.kochamkino.models;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name = "film")
public class Move {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private Date reliseDate;
    private String director;
    private float grade;
    private String genre;

    public Move(String title, Date reliseDate, String director, float grade, String genre){
        this.title = title;
        this.reliseDate = reliseDate;
        this.director = director;
        this.genre = genre;
    }



}
