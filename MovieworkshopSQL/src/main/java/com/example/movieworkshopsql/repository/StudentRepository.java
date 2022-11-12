package com.example.movieworkshopsql.repository;

import com.example.movieworkshopsql.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {

    private Connection conn = DatabaseConnectionManager.getConnection();

    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();

        try {
            // sql statement
            PreparedStatement psts = conn.prepareStatement("SELECT * FROM student;");
            ResultSet resultSet = psts.executeQuery();

            // add students
            while (resultSet.next()) {
                students.add(new Student(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("email"),
                        resultSet.getBoolean("gender")));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return students;
    }

}
