package com.example.internshipLogisticTool.data.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "session_id_generator")
    @SequenceGenerator(name = "session_id_generator", initialValue = 1000, allocationSize = 1)
    private Long id;

    @NotBlank
    private String date;

    //Relations ------------------------------------------------------------------------------

    @OneToMany(mappedBy = "session")
    private List<Grade> grades;

    @OneToMany(mappedBy = "session")
    private List<Attendance> attendances;

    @ManyToOne
    @JoinColumn(name = "activity_id", referencedColumnName = "id")
    private Activity activity;

}
