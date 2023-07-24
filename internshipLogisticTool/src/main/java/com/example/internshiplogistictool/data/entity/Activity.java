package com.example.internshiplogistictool.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "activity_id_generator")
    @SequenceGenerator(name = "activity_id_generator", initialValue = 1000, allocationSize = 1)
    private Long id;

    @NotBlank
    private String name;
    private String description;

    //Relations ------------------------------------------------------------------------------

    @JsonIgnore
    @ManyToMany(mappedBy = "activities")
    private List<Team> teams;

    @JsonIgnore
    @OneToMany(mappedBy = "activity")
    private List<Session> sessions;

}
