package com.example.internshiplogistictool.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    @NotNull
    private boolean leader;


    //Relations ------------------------------------------------------------------------------
    @JsonIgnoreProperties({"grades", "students", "activities"})
    @ManyToOne
    @JoinColumn(name = "team_id", referencedColumnName = "id")
    private Team team;

    @OneToMany(mappedBy = "student")
    private List<Attendance> attendances;

    @OneToMany(mappedBy = "student")
    private List<Grade> grades;

    public Student() {
    }

    public Student(String name, String email, String university, boolean leader, Team team) {
        this.name = name;
        this.email = email;
        this.university = university;
        this.leader = leader;
        this.team = team;
    }

    public Student(String name, String email, String university, boolean leader) {
        this.name = name;
        this.email = email;
        this.university = university;
        this.leader = leader;
    }
}
