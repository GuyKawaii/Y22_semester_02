package com.example.mysql.controller;

import com.example.mysql.model.Student;
import com.example.mysql.service.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    StudentService service = new StudentService();

    @GetMapping("/")
    public List<Student> index() {
        return service.getAllStudents();
    }
    @GetMapping("student")
    public Student getStudent(int id) {
        return service.getStudent(id);
    }
}
