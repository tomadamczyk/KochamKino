package com.example.kochamkino.models;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "użytkownik")
public class User {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    private String firstName;
    private String lastName;

    public User(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }



}
