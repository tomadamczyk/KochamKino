package com.example.kochamkino.dtos;

import lombok.Data;


@Data
public class MovieDto {
    private Long id;
    private String title;
    private float grade;
    private String genre;

    public MovieDto(Long id, String title, float grade, String genre) {
        this.id = id;
        this.title = title;
        this.grade = grade;
        this.genre = genre;
    }
}
