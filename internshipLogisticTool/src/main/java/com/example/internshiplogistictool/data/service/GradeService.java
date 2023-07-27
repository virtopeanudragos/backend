package com.example.internshiplogistictool.data.service;

import com.example.internshiplogistictool.data.entity.Grade;
import com.example.internshiplogistictool.data.repository.GradeRepository;
import com.example.internshiplogistictool.exceptions.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeService {

    private final GradeRepository gradeRepository;

    @Autowired
    public GradeService(GradeRepository gradeRepository) {
        this.gradeRepository = gradeRepository;
    }

    public List<Grade> getGradesByStudentAndSession(Long studentId, Long sessionId) {
        List<Grade> grades = gradeRepository.findByStudentIdAndSessionId(studentId, sessionId);
        if (grades != null && !grades.isEmpty()) {
            return grades;
        } else {
            throw new CustomException("No grades found for Student ID: " + studentId + " and Session ID: " + sessionId);
        }
    }

    public Grade createGrade(Grade grade) {
        return gradeRepository.save(grade);
    }

    public Grade updateGrade(Long studentId, Long sessionId, Grade grade) {
        Grade existingGrade = gradeRepository.findByIdAndStudentId(grade.getId(), studentId);
        if (existingGrade == null) {
            throw new RuntimeException("Grade not found with ID: " + grade.getId() + " and Student ID: " + studentId);
        }
      
        existingGrade.setGrade(grade.getGrade());
        existingGrade.setComment(grade.getComment());

        return gradeRepository.save(existingGrade);
    }
}
