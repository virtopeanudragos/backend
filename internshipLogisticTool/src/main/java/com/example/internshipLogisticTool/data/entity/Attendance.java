package com.example.internshipLogisticTool.data.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "attendance_id_generator")
    @SequenceGenerator(name = "attendance_id_generator", initialValue = 1000, allocationSize = 1)
    private Long id;

    @NotBlank
    private Long studentId;
    @NotBlank
    private Long sessionId;
    @NotBlank
    private boolean attended;

}
