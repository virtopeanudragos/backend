package com.example.internshipLogisticTool.data.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Collection;
import java.util.List;

@Data
@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "team_id_generator")
    @SequenceGenerator(name = "team_id_generator", initialValue = 1000, allocationSize = 1)
    private Long id;


    //Relations ------------------------------------------------------------------------------

    @OneToMany(mappedBy = "team")
    private List<Grade> grades;

    @OneToMany(mappedBy = "team")
    private List<Student> students;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "team_activity",
            joinColumns = @JoinColumn(name = "activity_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "team_id", referencedColumnName = "id")
    )
    private List<Activity> activities;



}
