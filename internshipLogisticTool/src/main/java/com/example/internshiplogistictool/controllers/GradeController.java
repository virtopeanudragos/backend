package com.example.internshiplogistictool.controllers;

import com.example.internshiplogistictool.data.dto.GradeDTO;
import com.example.internshiplogistictool.data.entity.Grade;
import com.example.internshiplogistictool.data.entity.Mentor;
import com.example.internshiplogistictool.data.entity.Session;
import com.example.internshiplogistictool.data.entity.Student;
import com.example.internshiplogistictool.data.service.GradeService;
import com.example.internshiplogistictool.data.service.MentorService;
import com.example.internshiplogistictool.data.service.SessionService;
import com.example.internshiplogistictool.data.service.StudentService;
import jakarta.validation.constraints.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grades")
public class GradeController {

    private final StudentService studentService;
    private final SessionService sessionService;
    private final MentorService mentorService;
    private final GradeService gradeService;

    @Autowired
    public GradeController(StudentService studentService, SessionService sessionService, MentorService mentorService, GradeService gradeService) {
        this.studentService = studentService;
        this.sessionService = sessionService;
        this.mentorService = mentorService;
        this.gradeService = gradeService;
    }

    @GetMapping
    public List<Grade> getGradesByStudentAndSession(@RequestParam Long studentId, @RequestParam Long sessionId) {
        return gradeService.getGradesByStudentAndSession(studentId, sessionId);
    }

    @PostMapping
    public Grade createGrade(@RequestParam Long studentId, @RequestParam Long sessionId, @RequestBody GradeDTO gradeDTO) {
        Session session = sessionService.getSessionById(sessionId);
        Student student = studentService.getStudentById(studentId);
        Mentor mentor = mentorService.getMentorById(gradeDTO.getMentorId());

        Grade grade = new Grade(
                gradeDTO.getGrade(),
                gradeDTO.getComment(),
                session,
                student,
                mentor
        );

        return gradeService.createGrade(grade);
    }

    @PutMapping
    public Grade updateGrade(@RequestBody GradeDTO gradeDTO) {
        Grade grade = gradeService.getGradeById(gradeDTO.getId());
        if(gradeDTO.getGrade() != 0.0f)
            grade.setGrade(gradeDTO.getGrade());
        if(gradeDTO.getComment() != null)
            grade.setComment(gradeDTO.getComment());
        return gradeService.updateGrade(grade);
    }
}
