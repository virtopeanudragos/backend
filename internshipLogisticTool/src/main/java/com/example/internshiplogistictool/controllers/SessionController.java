package com.example.internshiplogistictool.controllers;

import com.example.internshiplogistictool.data.entity.Session;
import com.example.internshiplogistictool.data.service.SessionService;
import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/session")
public class SessionController {

    private final SessionService sessionService;

    public SessionController(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @GetMapping
    public List<Session> getAllSessions (){
        return sessionService.getAllSessions();
    }

    @GetMapping("/{id}")
    public Session getSessionById(@PathVariable Long id){
        return sessionService.getSessionById(id);
    }

    @PostMapping
    public Session addSession(@RequestBody Session session){
        return sessionService.createSession(session);
    }


    @Transactional
    @DeleteMapping("/{id}")
    public void deleteSession(@PathVariable Long id){
        sessionService.deleteSessionById(id);
    }
}
