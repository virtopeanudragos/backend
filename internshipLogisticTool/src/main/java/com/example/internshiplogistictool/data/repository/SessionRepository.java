package com.example.internshiplogistictool.data.repository;

import com.example.internshiplogistictool.data.entity.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionRepository extends JpaRepository<Session, Long> {
}
