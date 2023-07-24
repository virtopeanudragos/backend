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

    @GetMapping("/{studentId}")
    public List<Attendance> getStudentAttendances (@PathVariable Long studentId){
        return studentService.getStudentById(studentId).getAttendances();
    }

    @PostMapping("/{studentId}/{sessionId}")
    public Attendance recordAttendance(@PathVariable Long studentId, @PathVariable Long sessionId, @RequestBody Attendance attendance){

        Session session = sessionService.getSessionById(sessionId);
        Student student = studentService.getStudentById(studentId);

        attendance.setSession(session);
        attendance.setStudent(student);

        return attendanceService.createAttendance(attendance);
    }

    @PutMapping("/{studentId}/{sessionId}")
    public Attendance updateAttendance(@PathVariable Long studentId, @PathVariable Long sessionId, @RequestBody Attendance attendance){

        Session session = sessionService.getSessionById(sessionId);
        Student student = studentService.getStudentById(studentId);

        return attendanceService.updateAttendance(attendance, student, session);
    }


}