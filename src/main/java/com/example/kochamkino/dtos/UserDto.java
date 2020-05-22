package com.example.kochamkino.dtos;


import lombok.Data;

@Data
public class UserDto {

    private String firstName;
    private String lastName;
    private char sex;
    private String email;
    private String username;
    private String password;

}
