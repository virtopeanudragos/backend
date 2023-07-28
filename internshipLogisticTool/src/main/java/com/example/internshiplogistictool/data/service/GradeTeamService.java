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
            throw new CustomException("No grades found for Team and Session");
        }
    }

    public GradeTeam createGradeTeam(GradeTeam gradeTeam) {
        return gradeTeamRepository.save(gradeTeam);
    }

    public GradeTeam updateGradeTeam(GradeTeam gradeTeam) {
        return gradeTeamRepository.save(gradeTeam);
    }

    public GradeTeam getGradeTeamById(Long id){
        return gradeTeamRepository.findById(id)
                .orElseThrow(() -> new CustomException("Grade not found"));
    }
}