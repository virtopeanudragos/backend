package com.example.internshiplogistictool.data.dto;

import lombok.Data;

@Data
public class GradeDTO {

    private Long id;
    private float grade;
    private String comment;
    private Long mentorId;
}
