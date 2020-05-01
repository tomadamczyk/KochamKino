package com.example.kochamkino.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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

    public Grade(int value, User grader){

        this.value = value;
        this.graders = grader;
    }

    @JsonIgnoreProperties("grades")
    @JsonBackReference
    @ManyToOne(optional = false)
    private User graders;

    @OneToOne(mappedBy = "grade")
    @JsonManagedReference
    private Movie movie;

    public User getGraders() {
        return graders;
    }

    public void setGraders(User graders) {
        this.graders = graders;
    }
}
