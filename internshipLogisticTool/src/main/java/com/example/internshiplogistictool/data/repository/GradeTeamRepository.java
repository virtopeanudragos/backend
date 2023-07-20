package com.example.internshiplogistictool.data.repository;

import com.example.internshiplogistictool.data.entity.GradeTeam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GradeTeamRepository extends JpaRepository<GradeTeam, Long> {
}
