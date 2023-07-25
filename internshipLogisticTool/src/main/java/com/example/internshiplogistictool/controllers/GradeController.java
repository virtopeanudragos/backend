package com.example.internshiplogistictool.controllers;

import com.example.internshiplogistictool.data.entity.Grade;
import com.example.internshiplogistictool.data.entity.Session;
import com.example.internshiplogistictool.data.entity.Student;
import com.example.internshiplogistictool.data.service.GradeService;
import com.example.internshiplogistictool.data.service.SessionService;
import com.example.internshiplogistictool.data.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grades")
public class GradeController {

    private final StudentService studentService;
    private final SessionService sessionService;

    private final GradeService gradeService;

    @Autowired
    public GradeController(StudentService studentService, SessionService sessionService, GradeService gradeService) {
        this.studentService = studentService;
        this.sessionService = sessionService;
        this.gradeService = gradeService;
    }

    @GetMapping("/{studentId}/{sessionId}")
    public List<Grade> getGradesByStudentAndSession(@PathVariable Long studentId, @PathVariable Long sessionId) {
        return gradeService.getGradesByStudentAndSession(studentId, sessionId);
    }

    @PostMapping("/{studentId}/{sessionId}")
    public Grade createGrade(@PathVariable Long studentId, @PathVariable Long sessionId, @RequestBody Grade grade) {
        Session session = sessionService.getSessionById(sessionId);
        Student student = studentService.getStudentById(studentId);

        grade.setStudent(student);
        grade.setSession(session);

        return gradeService.createGrade(grade);
    }

    @PutMapping("/{studentId}/{sessionId}")
    public Grade updateGrade(@PathVariable Long studentId, @PathVariable Long sessionId, @RequestBody Grade grade) {
        return gradeService.updateGrade(studentId, sessionId, grade);
    }
}
