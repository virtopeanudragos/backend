package com.example.internshipLogisticTool.data.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

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

}
