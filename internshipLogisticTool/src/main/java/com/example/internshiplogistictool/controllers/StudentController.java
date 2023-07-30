package com.example.internshiplogistictool.controllers;

import com.example.internshiplogistictool.data.dto.StudentDTO;
import com.example.internshiplogistictool.data.entity.Student;
import com.example.internshiplogistictool.data.entity.Team;
import com.example.internshiplogistictool.data.service.StudentService;
import com.example.internshiplogistictool.data.service.TeamService;
import com.example.internshiplogistictool.exceptions.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
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
    public ResponseEntity<Student> createStudentAndAddToTeam(@RequestBody StudentDTO studentDTO){
        Student student = new Student(
                studentDTO.getName(),
                studentDTO.getEmail(),
                studentDTO.getUniversity(),
                studentDTO.isLeader()
        );
        if(studentDTO.getTeamId() != null)
            student.setTeam(teamService.getTeamById(studentDTO.getTeamId()));

        Student result = studentService.createStudent(student);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PutMapping
    public ResponseEntity<Student> updateStudentTeam(@RequestBody StudentDTO studentDTO){
        Student student = studentService.getStudentById(studentDTO.getId());
        if(studentDTO.getTeamId() != null)
            if(student.getTeam() != null)
                throw new CustomException("Student is already in a team");
            else
                student.setTeam(teamService.getTeamById(studentDTO.getTeamId()));
        else
            student.setTeam(null);
        Student result = studentService.updateStudent(student);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
