package com.example.internshiplogistictool.controllers;

import com.example.internshiplogistictool.data.entity.Student;
import com.example.internshiplogistictool.data.entity.Team;
import com.example.internshiplogistictool.data.service.StudentService;
import com.example.internshiplogistictool.data.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;
    private final TeamService teamService;

    @Autowired
    public StudentController(StudentService studentService, TeamService teamService) {
        this.studentService = studentService;
        this.teamService = teamService;
    }

    @GetMapping
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id){
        return studentService.getStudentById(id);
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student){
        return studentService.createStudent(student);
    }

    @PostMapping("/{id}")
    public ResponseEntity<Student> addStudentToTeam(@RequestBody Student student, @PathVariable Long id){
        Team team = teamService.getTeamById(id);
        student.setTeam(team);
        Student result = studentService.createStudent(student);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
