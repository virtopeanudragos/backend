package com.example.internshiplogistictool.data.repository;

import com.example.internshiplogistictool.data.entity.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MentorRepository extends JpaRepository<Mentor, Long> {
}

