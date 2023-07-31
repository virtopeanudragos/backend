package com.example.internshiplogistictool.controllers;

import com.example.internshiplogistictool.data.entity.Grade;
import com.example.internshiplogistictool.data.entity.GradeTeam;
import com.example.internshiplogistictool.data.entity.Student;
import com.example.internshiplogistictool.data.entity.Team;
import com.example.internshiplogistictool.data.service.StudentService;
import com.example.internshiplogistictool.data.service.TeamService;
import org.apache.commons.io.IOUtils;
import org.dhatim.fastexcel.Workbook;
import org.dhatim.fastexcel.Worksheet;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/downloadReport")
public class ExcelController {
    private final StudentService studentService;
    private final TeamService teamService;

    public ExcelController(StudentService studentService, TeamService teamService) {
        this.studentService = studentService;
        this.teamService = teamService;
    }

    private void generateReport() throws IOException {

        List<Student> students = studentService.getAllStudents();
        List<Team> teams = teamService.getAllTeams();
        try (OutputStream outputStream = Files.newOutputStream(Paths.get("ExcelSheets/GradesStatus.xlsx"))) {
            Workbook workbook = new Workbook(outputStream, "Grades", "1.0");

            Worksheet studentWorksheet = workbook.newWorksheet("Student Grades");
            int row = 1;
            for(Student student: students){
                studentWorksheet.value(0, 0, "Student");
                studentWorksheet.value(0, 1, "Mentor");
                studentWorksheet.value(0, 2, "Session date");
                studentWorksheet.value(0, 3, "Grade");
                studentWorksheet.value(0, 4, "Comment");

                studentWorksheet.style(0, 0).fillColor("99CCFF").bold().set();
                studentWorksheet.style(0, 1).fillColor("99CCFF").bold().set();
                studentWorksheet.style(0, 2).fillColor("99CCFF").bold().set();
                studentWorksheet.style(0, 3).fillColor("99CCFF").bold().set();
                studentWorksheet.style(0, 4).fillColor("99CCFF").bold().set();


                for(Grade grade: student.getGrades()){
                    studentWorksheet.value(row, 0, grade.getStudent().getName());
                    studentWorksheet.value(row, 1, grade.getMentor().getName());
                    studentWorksheet.value(row, 2, grade.getSession().getDate());
                    studentWorksheet.value(row, 3, grade.getGrade());
                    studentWorksheet.value(row, 4, grade.getComment());
                    row++;
                }
            }

            Worksheet teamWorksheet = workbook.newWorksheet("Team Grades");
            row = 1;
            for(Team team: teams){

                teamWorksheet.value(0, 0, "Team");
                teamWorksheet.value(0, 1, "Mentor");
                teamWorksheet.value(0, 2, "Session date");
                teamWorksheet.value(0, 3, "Grade");
                teamWorksheet.value(0, 4, "Comment");

                teamWorksheet.style(0, 0).fillColor("99CCFF").bold().set();
                teamWorksheet.style(0, 1).fillColor("99CCFF").bold().set();
                teamWorksheet.style(0, 2).fillColor("99CCFF").bold().set();
                teamWorksheet.style(0, 3).fillColor("99CCFF").bold().set();
                teamWorksheet.style(0, 4).fillColor("99CCFF").bold().set();


                for(GradeTeam gradeTeam: team.getGrades()){
                    teamWorksheet.value(row, 0, gradeTeam.getId());
                    teamWorksheet.value(row, 1, gradeTeam.getMentor().getName());
                    teamWorksheet.value(row, 2, gradeTeam.getSession().getDate());
                    teamWorksheet.value(row, 3, gradeTeam.getGrade());
                    teamWorksheet.value(row, 4, gradeTeam.getComment());
                    row++;
                }
            }

            workbook.finish();
        }
    }

    @GetMapping
    public ResponseEntity<?> download() throws IOException {
        generateReport();
        String fileName = "ExcelSheets/GradesStatus.xlsx";
        try {
            InputStream is = new FileInputStream(fileName);
            return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; fileName=GradesStatus.xlsx" ).contentType(MediaType.parseMediaType("application/vnd.ms-excel")).body(IOUtils.toByteArray(is));
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
