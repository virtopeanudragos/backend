package com.example.internshiplogistictool.data.repository;

import com.example.internshiplogistictool.data.entity.GradeTeam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GradeTeamRepository extends JpaRepository<GradeTeam, Long> {
    List<GradeTeam> findByTeamIdAndSessionId(Long teamId, Long sessionId);
}

