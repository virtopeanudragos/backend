package com.example.internshiplogistictool.data.service;

import com.example.internshiplogistictool.data.entity.Attendance;
import com.example.internshiplogistictool.data.entity.Session;
import com.example.internshiplogistictool.data.entity.Student;
import com.example.internshiplogistictool.data.repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AttendanceService {
    private final AttendanceRepository attendanceRepository;

    @Autowired
    public AttendanceService(AttendanceRepository attendanceRepository) {
        this.attendanceRepository = attendanceRepository;
    }

    public Attendance createAttendance(Attendance attendance){
        return attendanceRepository.save(attendance);
    }

    public Attendance updateAttendance(Attendance attendance, Student student, Session session){
        Optional<Attendance> oldAttendace = attendanceRepository.findAttendanceByStudentAndSession(student, session);
        if(oldAttendace.isPresent()){
            attendance.setId(oldAttendace.get().getId());
            attendance.setStudent(oldAttendace.get().getStudent());
            attendance.setSession(oldAttendace.get().getSession());
        }


        return attendanceRepository.save(attendance);
    }
}
