package com.example.internshiplogistictool.controllers;

import com.example.internshiplogistictool.data.entity.Attendance;
import com.example.internshiplogistictool.data.entity.Session;
import com.example.internshiplogistictool.data.entity.Student;
import com.example.internshiplogistictool.data.service.AttendanceService;
import com.example.internshiplogistictool.data.service.SessionService;
import com.example.internshiplogistictool.data.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200/ ")
@RequestMapping("/attendance")
public class AttendanceController {

    private final StudentService studentService;
    private final SessionService sessionService;
    private final AttendanceService attendanceService;

    @Autowired
    public AttendanceController(StudentService studentService, SessionService sessionService, AttendanceService attendanceService) {
        this.studentService = studentService;
        this.sessionService = sessionService;
        this.attendanceService = attendanceService;
    }

    @GetMapping
    public List<Attendance> getStudentAttendances (@RequestParam Long studentId){
        return studentService.getStudentById(studentId).getAttendances();
    }

    @PostMapping
    public Attendance recordAttendance(@RequestParam Long studentId, @RequestParam Long sessionId, @RequestBody Attendance attendance){

        Session session = sessionService.getSessionById(sessionId);
        Student student = studentService.getStudentById(studentId);

        attendance.setSession(session);
        attendance.setStudent(student);

        return attendanceService.createAttendance(attendance);
    }

    @PutMapping
    public Attendance updateAttendance(@RequestParam Long studentId, @RequestParam Long sessionId, @RequestBody Attendance attendance){

        Session session = sessionService.getSessionById(sessionId);
        Student student = studentService.getStudentById(studentId);

        return attendanceService.updateAttendance(attendance, student, session);
    }


}
