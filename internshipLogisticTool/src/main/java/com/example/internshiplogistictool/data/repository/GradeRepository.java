package com.example.internshiplogistictool.data.repository;

import com.example.internshiplogistictool.data.entity.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Long> {
    List<Grade> findByStudentId(Long studentId);
    List<Grade> findByStudentIdAndSessionId(Long studentId, Long sessionId);
    Grade findByIdAndStudentId(Long id, Long studentId);
}
