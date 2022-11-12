package com.example.mysql.controller;

import com.example.mysql.model.Student;
import com.example.mysql.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    private StudentService studentService = new StudentService();

    // show all students in html
    @GetMapping("/students")
    public String students(Model model) {

        List<Student> studentList = studentService.getAllStudents();


        model.addAttribute("studentList", studentList);

        return "students";
    }



    @GetMapping("/create")
    public String index() {
        return "index";
    }

    @PostMapping("/create")
    public String create(WebRequest req) {

        studentService.createStudent(req);

//        System.out.println(req.getParameter("name"));
//        System.out.println(req.getParameter("email"));
//        System.out.println(req.getParameter("gender"));
        return "redirect:/";
    }
}
