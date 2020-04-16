package com.example.kochamkino.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "rezyser")
@Data
public class Director{

    @Id
    @GeneratedValue
    private Long id;

    private String firstName;
    private String lastName;

    @OneToMany(mappedBy = "director")
    private Set<Movie> movies;

    public Director(){}

    public Director(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

}
