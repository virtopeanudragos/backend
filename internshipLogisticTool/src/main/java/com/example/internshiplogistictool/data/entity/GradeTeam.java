package com.example.internshiplogistictool.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
public class GradeTeam {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "grade_id_generator")
    @SequenceGenerator(name = "grade_id_generator", initialValue = 1000, allocationSize = 1)
    private Long id;

    @NotNull
    private float grade;
    private String comment;

    //Relations ------------------------------------------------------------------------------

    @JsonIgnoreProperties({"id", "gradesTeam", "grades", "attendances", "activity"})
    @ManyToOne
    @JoinColumn(name = "session_id", referencedColumnName = "id")
    private Session session;

    @JsonIgnoreProperties({"grades", "activities"})
    @ManyToOne
    @JoinColumn(name = "team_id", referencedColumnName = "id")
    private Team team;

    @JsonIgnoreProperties({"gradeTeam", "grade", "email"})
    @ManyToOne
    @JoinColumn(name = "mentor_id", referencedColumnName = "id")
    private Mentor mentor;


    public GradeTeam(float grade, String comment, Session session, Team team, Mentor mentor) {
        this.grade = grade;
        this.comment = comment;
        this.session = session;
        this.team = team;
        this.mentor = mentor;
    }

    public GradeTeam() {
    }
}
