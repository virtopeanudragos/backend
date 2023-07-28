package com.example.internshiplogistictool.data.service;

import com.example.internshiplogistictool.data.entity.Session;
import com.example.internshiplogistictool.data.repository.SessionRepository;
import com.example.internshiplogistictool.exceptions.CustomException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SessionService {

    private final SessionRepository sessionRepository;

    public SessionService(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    public Session getSessionById(Long id){
        return sessionRepository.findById(id)
                .orElseThrow(() -> new CustomException("Session not found with id: " + id));
    }

    public List<Session> getAllSessions(){
        return sessionRepository.findAll();
    }

    public Session createSession(Session session){
        return sessionRepository.save(session);
    }

    public void deleteSessionById(Long id){
        sessionRepository.deleteSessionById(id);
    }
}
