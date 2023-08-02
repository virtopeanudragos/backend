package com.example.internshiplogistictool.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "grade_id_generator")
    @SequenceGenerator(name = "grade_id_generator", initialValue = 1000, allocationSize = 1)
    private Long id;

    @NotNull
    private float grade;
    private String comment;

    //Relations ------------------------------------------------------------------------------
    @JsonIgnoreProperties({"grades", "gradesTeam","attendances"})
    @ManyToOne
    @JoinColumn(name = "session_id", referencedColumnName = "id")
    private Session session;

    @JsonIgnoreProperties({"email", "university", "leader", "team", "attendances", "grades"})
    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Student student;

    @JsonIgnoreProperties({"email", "grade", "gradeTeam"})
    @ManyToOne
    @JoinColumn(name = "mentor_id", referencedColumnName = "id")
    private Mentor mentor;

    public Grade(float grade, String comment, Session session, Student student, Mentor mentor) {
        this.grade = grade;
        this.comment = comment;
        this.session = session;
        this.student = student;
        this.mentor = mentor;
    }

    public Grade() {
    }
}
