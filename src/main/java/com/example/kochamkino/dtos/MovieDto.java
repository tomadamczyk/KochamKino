package com.example.kochamkino.dtos;

import lombok.Data;

import java.util.Date;

@Data
public class MovieDto {
    private Long id;
    private String title;
    private String director;
    private float grade;
    private String genre;



}
