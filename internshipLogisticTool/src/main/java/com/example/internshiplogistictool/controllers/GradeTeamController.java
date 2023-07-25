package com.example.internshiplogistictool.controllers;

import com.example.internshiplogistictool.data.entity.GradeTeam;
import com.example.internshiplogistictool.data.service.GradeTeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gradesTeam")
public class GradeTeamController {

    private final GradeTeamService gradeTeamService;

    @Autowired
    public GradeTeamController(GradeTeamService gradeTeamService) {
        this.gradeTeamService = gradeTeamService;
    }

    @GetMapping("/{teamId}/{sessionId}")
    public List<GradeTeam> getGradesByTeamAndSession(@PathVariable Long teamId, @PathVariable Long sessionId) {
        return gradeTeamService.getGradesByTeamAndSession(teamId, sessionId);
    }

    @PostMapping
    public GradeTeam createGradeTeam(@RequestBody GradeTeam gradeTeam) {
        return gradeTeamService.createGradeTeam(gradeTeam);
    }

    @PutMapping("/{teamId}/{sessionId}")
    public GradeTeam updateGradeTeam(@PathVariable Long teamId, @PathVariable Long sessionId, @RequestBody GradeTeam gradeTeam) {
        return gradeTeamService.updateGradeTeam(teamId, sessionId, gradeTeam);
    }
}
