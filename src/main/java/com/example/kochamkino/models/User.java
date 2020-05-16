package com.example.kochamkino.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "`user`")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String firstName;
    private String lastName;
    private char sex;
    private boolean isAdmin;
    private String email;
    private String login;
    private String password;
    @Transient
    private String passwordConfirm;



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

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String encode) {
        this.password = encode;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }
}
