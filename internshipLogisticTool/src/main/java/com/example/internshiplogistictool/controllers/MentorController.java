package com.example.internshiplogistictool.controllers;

import com.example.internshiplogistictool.data.entity.Mentor;
import com.example.internshiplogistictool.data.service.MentorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/mentors")
public class MentorController {

    private final MentorService mentorService;

    @Autowired
    public MentorController(MentorService mentorService) {
        this.mentorService = mentorService;
    }

    @GetMapping
    public List<Mentor> getAllMentors() {
        return mentorService.getAllMentors();
    }

    @PostMapping
    public Mentor createMentor(@RequestBody Mentor mentor) {
        return mentorService.createMentor(mentor);
    }

    @GetMapping("/{id}")
    public Mentor getMentorById(@PathVariable Long id) {
        return mentorService.getMentorById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteMentor(@PathVariable Long id) {
        mentorService.deleteMentor(id);
    }
}

