package com.example.internshiplogistictool.controllers;

import com.example.internshiplogistictool.data.entity.Grade;
import com.example.internshiplogistictool.data.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grades")
public class GradeController {

    private final GradeService gradeService;

    @Autowired
    public GradeController(GradeService gradeService) {
        this.gradeService = gradeService;
    }

    @GetMapping("/{studentId}/{sessionId}")
    public List<Grade> getGradesByStudentAndSession(@PathVariable Long studentId, @PathVariable Long sessionId) {
        return gradeService.getGradesByStudentAndSession(studentId, sessionId);
    }

    @PostMapping
    public Grade createGrade(@RequestBody Grade grade) {
        return gradeService.createGrade(grade);
    }

    @PutMapping("/{studentId}/{sessionId}")
    public Grade updateGrade(@PathVariable Long studentId, @PathVariable Long sessionId, @RequestBody Grade grade) {
        return gradeService.updateGrade(studentId, sessionId, grade);
    }
}
