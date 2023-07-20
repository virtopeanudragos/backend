package com.example.internshipLogisticTool.repositories;

import com.example.internshipLogisticTool.data.entity.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MentorRepository extends JpaRepository<Mentor, Long> {
}

