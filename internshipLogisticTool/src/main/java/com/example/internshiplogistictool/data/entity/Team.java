package com.example.internshiplogistictool.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "team_id_generator")
    @SequenceGenerator(name = "team_id_generator", initialValue = 1000, allocationSize = 1)
    private Long id;


    //Relations ------------------------------------------------------------------------------

    @JsonIgnoreProperties({"team", "id"})
    @OneToMany(mappedBy = "team")
    private List<GradeTeam> grades;

    @JsonIgnoreProperties({"email", "university", "team", "attendances", "grades"})
    @OneToMany(mappedBy = "team")
    private List<Student> students;

    @JsonIgnoreProperties({"teams", "session"})
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "team_activity",
            joinColumns = @JoinColumn(name = "activity_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "team_id", referencedColumnName = "id")
    )
    private List<Activity> activities;



}
