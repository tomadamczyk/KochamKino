package com.example.kochamkino.dtos;

import lombok.Data;


@Data
public class MovieDto {
    private Long id;
    private String title;
    private String director;
    private float grade;
    private String genre;



}
