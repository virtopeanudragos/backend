package com.example.internshiplogistictool.data.dto;


import lombok.Data;

@Data
public class StudentDTO {

    private Long id;
    private String name;
    private String email;
    private String university;
    private boolean leader;

    private Long teamId;
}
