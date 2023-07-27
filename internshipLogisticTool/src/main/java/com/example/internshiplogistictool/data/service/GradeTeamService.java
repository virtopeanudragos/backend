package com.example.internshiplogistictool.data.service;

import com.example.internshiplogistictool.data.entity.GradeTeam;
import com.example.internshiplogistictool.data.repository.GradeTeamRepository;
import com.example.internshiplogistictool.exceptions.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeTeamService {

    private final GradeTeamRepository gradeTeamRepository;

    @Autowired
    public GradeTeamService(GradeTeamRepository gradeTeamRepository) {
        this.gradeTeamRepository = gradeTeamRepository;
    }

    public List<GradeTeam> getGradesByTeamAndSession(Long teamId, Long sessionId) {
        List<GradeTeam> grades = gradeTeamRepository.findByTeamIdAndSessionId(teamId, sessionId);
        if (grades != null && !grades.isEmpty()) {
            return grades;
        } else {
            throw new CustomException("No grades found for Team ID: " + teamId + " and Session ID: " + sessionId);
        }
    }

    public GradeTeam createGradeTeam(GradeTeam gradeTeam) {
        return gradeTeamRepository.save(gradeTeam);
    }

    public GradeTeam updateGradeTeam(Long teamId, Long sessionId, GradeTeam gradeTeam) {
        GradeTeam existingGradeTeam = gradeTeamRepository.findById(gradeTeam.getId())
                .orElseThrow(() -> new RuntimeException("GradeTeam not found with ID: " + gradeTeam.getId()));
        existingGradeTeam.setGrade(gradeTeam.getGrade());
        existingGradeTeam.setComment(gradeTeam.getComment());

        return gradeTeamRepository.save(existingGradeTeam);
    }
}