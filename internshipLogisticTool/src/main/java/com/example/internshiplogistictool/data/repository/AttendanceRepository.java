package com.example.internshiplogistictool.data.repository;

import com.example.internshiplogistictool.data.entity.Attendance;
import com.example.internshiplogistictool.data.entity.Session;
import com.example.internshiplogistictool.data.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    Optional<Attendance> findAttendanceByStudentAndSession(Student student, Session session);
}
