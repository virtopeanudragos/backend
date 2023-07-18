package com.example.internshipLogisticTool.data.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "team_id_generator")
    @SequenceGenerator(name = "team_id_generator", initialValue = 1000, allocationSize = 1)
    private Long id;

}
