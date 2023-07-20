package com.example.internshiplogistictool.data.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "grade_id_generator")
    @SequenceGenerator(name = "grade_id_generator", initialValue = 1000, allocationSize = 1)
    private Long id;

    @NotBlank
    private float grade;
    private String comment;

    //Relations ------------------------------------------------------------------------------

    @ManyToOne
    @JoinColumn(name = "session_id", referencedColumnName = "id")
    private Session session;

    @ManyToOne
    @JoinColumn(name = "team_id", referencedColumnName = "id")
    private Team team;

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Student student;

}
