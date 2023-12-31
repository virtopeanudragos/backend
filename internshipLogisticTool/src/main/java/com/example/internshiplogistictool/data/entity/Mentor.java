package com.example.internshiplogistictool.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Mentor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mentor_id_generator")
    @SequenceGenerator(name = "mentor_id_generator", initialValue = 1000, allocationSize = 1)
    private Long id;

    @NotBlank
    private String name;
    @NotBlank
    private String email;

    @JsonIgnore
    @OneToMany(mappedBy = "mentor")
    private List<GradeTeam> gradeTeam;

    @JsonIgnore
    @OneToMany(mappedBy = "mentor")
    private List<Grade> grade;

}
