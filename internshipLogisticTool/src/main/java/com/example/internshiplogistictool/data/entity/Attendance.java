package com.example.internshiplogistictool.data.entity;

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
    private boolean attended;

    //Relations ------------------------------------------------------------------------------

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "session_id", referencedColumnName = "id")
    private Session session;


}
