package com.example.internshiplogistictool.data.service;

import com.example.internshiplogistictool.data.entity.Mentor;
import com.example.internshiplogistictool.data.repository.MentorRepository;
import com.example.internshiplogistictool.exceptions.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MentorService {

    private final MentorRepository mentorRepository;

    @Autowired
    public MentorService(MentorRepository mentorRepository) {
        this.mentorRepository = mentorRepository;
    }

    public List<Mentor> getAllMentors() {
        return mentorRepository.findAll();
    }

    public Mentor getMentorById(Long id) {
        return mentorRepository.findById(id)
                .orElseThrow(() -> new CustomException("Mentor not found"));
    }

    public Mentor createMentor(Mentor mentor) {
        return mentorRepository.save(mentor);
    }

    public void deleteMentor(Long id) {
        mentorRepository.deleteById(id);
    }
}

