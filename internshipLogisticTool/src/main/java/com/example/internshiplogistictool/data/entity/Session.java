package com.example.internshiplogistictool.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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

    @JsonIgnoreProperties({"id", "session"})
    @OneToMany(mappedBy = "session")
    private List<GradeTeam> gradesTeam;

    @JsonIgnoreProperties({"id", "session"})
    @OneToMany(mappedBy = "session")
    private List<Grade> grades;

    @JsonIgnore
    @OneToMany(mappedBy = "session")
    private List<Attendance> attendances;

    @JsonIgnoreProperties({"description", "teams", "session"})
    @ManyToOne
    @JoinColumn(name = "activity_id", referencedColumnName = "id")
    private Activity activity;

}
