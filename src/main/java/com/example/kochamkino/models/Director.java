package com.example.kochamkino.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "rezyser")
@Data
public class Director{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long directorId;

    private String firstName;
    private String lastName;

    @JsonBackReference
    @OneToMany(mappedBy = "director")
    private List<Movie> movies = new LinkedList<Movie>();

    public Director(){}

    public Director(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

}
