package com.example.internshiplogistictool.controllers;

import com.example.internshiplogistictool.data.entity.GradeTeam;
import com.example.internshiplogistictool.data.entity.Session;
import com.example.internshiplogistictool.data.entity.Team;
import com.example.internshiplogistictool.data.service.GradeTeamService;
import com.example.internshiplogistictool.data.service.SessionService;
import com.example.internshiplogistictool.data.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gradesTeam")
public class GradeTeamController {
    private final TeamService teamService;
    private final SessionService sessionService;

    private final GradeTeamService gradeTeamService;

    @Autowired
    public GradeTeamController(TeamService teamService, SessionService sessionService, GradeTeamService gradeTeamService) {
        this.teamService = teamService;
        this.sessionService = sessionService;
        this.gradeTeamService = gradeTeamService;
    }

    @GetMapping("/{teamId}/{sessionId}")
    public List<GradeTeam> getGradesByTeamAndSession(@PathVariable Long teamId, @PathVariable Long sessionId) {
        return gradeTeamService.getGradesByTeamAndSession(teamId, sessionId);
    }

    @PostMapping("/{teamId}/{sessionId}")
    public GradeTeam createGradeTeam(@PathVariable Long teamId, @PathVariable Long sessionId, @RequestBody GradeTeam gradeTeam) {
        Session session = sessionService.getSessionById(sessionId);
        Team team = teamService.getTeamById(teamId);

        gradeTeam.setTeam(team);
        gradeTeam.setSession(session);

        return gradeTeamService.createGradeTeam(gradeTeam);
    }

    @PutMapping("/{teamId}/{sessionId}")
    public GradeTeam updateGradeTeam(@PathVariable Long teamId, @PathVariable Long sessionId, @RequestBody GradeTeam gradeTeam) {
        return gradeTeamService.updateGradeTeam(teamId, sessionId, gradeTeam);
    }
}
