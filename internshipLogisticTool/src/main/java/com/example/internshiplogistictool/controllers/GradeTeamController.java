package com.example.internshiplogistictool.controllers;

import com.example.internshiplogistictool.data.dto.GradeDTO;
import com.example.internshiplogistictool.data.entity.*;
import com.example.internshiplogistictool.data.service.GradeTeamService;
import com.example.internshiplogistictool.data.service.MentorService;
import com.example.internshiplogistictool.data.service.SessionService;
import com.example.internshiplogistictool.data.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/gradesTeam")
public class GradeTeamController {
    private final TeamService teamService;
    private final SessionService sessionService;
    private final MentorService mentorService;
    private final GradeTeamService gradeTeamService;

    @Autowired
    public GradeTeamController(TeamService teamService, SessionService sessionService, MentorService mentorService, GradeTeamService gradeTeamService) {
        this.teamService = teamService;
        this.sessionService = sessionService;
        this.mentorService = mentorService;
        this.gradeTeamService = gradeTeamService;
    }

    @GetMapping
    public List<GradeTeam> getGradesByTeamAndSession(@RequestParam Long teamId, @RequestParam Long sessionId) {
        return gradeTeamService.getGradesByTeamAndSession(teamId, sessionId);
    }

    @PostMapping
    public GradeTeam createGradeTeam(@RequestParam Long teamId, @RequestParam Long sessionId, @RequestBody GradeDTO gradeDTO) {
        Session session = sessionService.getSessionById(sessionId);
        Team team = teamService.getTeamById(teamId);
        Mentor mentor = mentorService.getMentorById(gradeDTO.getMentorId());

        GradeTeam gradeTeam = new GradeTeam(
                gradeDTO.getGrade(),
                gradeDTO.getComment(),
                session,
                team,
                mentor
        );

        return gradeTeamService.createGradeTeam(gradeTeam);
    }

    @PutMapping
    public GradeTeam updateGradeTeam(@RequestBody GradeDTO gradeDTO) {
        GradeTeam gradeTeam = gradeTeamService.getGradeTeamById(gradeDTO.getId());
        if(gradeDTO.getGrade() != 0.0f)
            gradeTeam.setGrade(gradeDTO.getGrade());
        if(gradeDTO.getComment() != null)
            gradeTeam.setComment(gradeDTO.getComment());

        return gradeTeamService.updateGradeTeam(gradeTeam);
    }
}
