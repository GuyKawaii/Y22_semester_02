package com.example.mysql.service;

import com.example.mysql.model.Student;
import com.example.mysql.repository.DatabaseConnectionManager;
import com.example.mysql.repository.StudentRepository;
import org.springframework.web.context.request.WebRequest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class StudentService {
    StudentRepository stuRepo = new StudentRepository();
    private Connection conn = DatabaseConnectionManager.getConnection();

    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        PreparedStatement psts;
        try {
            psts = conn.prepareStatement("SELECT * FROM student");
            ResultSet resultSet = psts.executeQuery();
            while (resultSet.next()) {
                students.add(new Student(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("email"),
                        resultSet.getBoolean("gender")
                ));
            }
        } catch (Exception e) {
            System.out.println("can't find database");
        }

        return students;
    }

    public Student getStudent(int id) {
        Student student;
        try {
            PreparedStatement psts = conn.prepareStatement("SELECT * FROM student WHERE ID = ?");
            psts.setInt(1, id);
            ResultSet resultset = psts.executeQuery();

            if (resultset.next()) {
                return new Student(
                        resultset.getInt("ID"),
                        resultset.getString("name"),
                        resultset.getString("email"),
                        resultset.getBoolean("gender")
                );
            }
        } catch (SQLException e) {
            System.out.println("SQL Error No. 14256. Please contact support");
        }
        return null;
    }

    public void createStudent(WebRequest req) {
        // request parameters
        boolean gender = Objects.requireNonNull(req.getParameter("gender")).equalsIgnoreCase("mand");
        String name = req.getParameter("name");
        String email = req.getParameter("email");

        // create student
        Student student = new Student(name, email, gender);

        // update dbms
        stuRepo.create(student);
    }


}
