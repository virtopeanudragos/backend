package com.example.internshiplogistictool.data.service;

import com.example.internshiplogistictool.data.entity.Student;
import com.example.internshiplogistictool.data.entity.Team;
import com.example.internshiplogistictool.data.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {

    private final TeamRepository teamRepository;

    @Autowired
    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    public Team getTeamById(Long id) {
        return teamRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Team not found with id: " + id));
    }

    public Team createTeam(Team team) {
        return teamRepository.save(team);
    }

    public void deleteTeam(Long id) {
        teamRepository.deleteById(id);
    }

    public void addMemberToTeam(Long id, Student student){
        Team team = getTeamById(id);
        List<Student> teamMembers = team.getStudents();
        teamMembers.add(student);
        team.setStudents(teamMembers);
        teamRepository.save(team);
    }
}

