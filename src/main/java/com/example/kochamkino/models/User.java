package com.example.kochamkino.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import javax.persistence.*;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@Data
@Entity
@Table(name = "`user`")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private char sex;
    private boolean isAdmin;
    private String email;
    private String login;
    private String password;

    @JsonManagedReference
    @OneToMany(mappedBy = "graders", cascade = CascadeType.ALL)
    private List<Grade> grades = new LinkedList<>();


    public User(){}

    public User(String firstName, String lastName, char sex, String email, String login, String password, boolean isAdmin) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.email = email;
        this.login = login;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public void addGrade(Grade grade){
        this.grades.add(grade);
    }


}
