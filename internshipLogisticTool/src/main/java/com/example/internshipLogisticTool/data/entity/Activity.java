package com.example.internshipLogisticTool.data.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

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

}