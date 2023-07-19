package com.example.internshipLogisticTool.data.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id_generator")
    @SequenceGenerator(name = "user_id_generator", initialValue = 1000, allocationSize = 1)
    private Long id;

    @NotBlank
    private String name;
    @NotBlank
    private String email;
    private String university;
    @NotBlank
    private boolean leader;


    //Relations ------------------------------------------------------------------------------

    @ManyToOne
    @JoinColumn(name = "team_id", referencedColumnName = "id")
    private Team team;

    @OneToMany(mappedBy = "student")
    private List<Attendance> attendances;

    @OneToMany(mappedBy = "student")
    private List<Grade> grades;

}
