package com.example.kochamkino.dtos;

import lombok.Data;

import java.util.Date;

@Data
public class MoveDto {
    private Long id;
    private String title;
    private Date reliseDate;
    private String director;
    private float grade;
    private String genre;



}
