package com.example.internshiplogistictool.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "attendance_id_generator")
    @SequenceGenerator(name = "attendance_id_generator", initialValue = 1000, allocationSize = 1)
    private Long id;

    @NotNull
    private boolean attended;

    //Relations ------------------------------------------------------------------------------

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Student student;

    @JsonIgnoreProperties({"id", "gradesTeam", "grades", "attendances", "activity"})
    @ManyToOne
    @JoinColumn(name = "session_id", referencedColumnName = "id")
    private Session session;


}
