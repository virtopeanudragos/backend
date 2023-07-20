package com.example.internshiplogistictool.data.repository;

import com.example.internshiplogistictool.data.entity.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Long> {
}
