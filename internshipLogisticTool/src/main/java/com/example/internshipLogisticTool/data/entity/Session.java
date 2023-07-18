package com.example.internshipLogisticTool.data.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "session_id_generator")
    @SequenceGenerator(name = "session_id_generator", initialValue = 1000, allocationSize = 1)
    private Long id;

    @NotBlank
    private Long activityId;
    @NotBlank
    private String date;

}
