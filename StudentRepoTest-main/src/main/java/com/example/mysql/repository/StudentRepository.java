package com.example.mysql.repository;

import com.example.mysql.model.Student;

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
            PreparedStatement psts = conn.prepareStatement("SELECT * FROM STUDENT WHERE ID = ?");
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


    public void create(Student student) {
        try {
            PreparedStatement psts = conn.prepareStatement(
                    "INSERT INTO student (name, email, gender) VALUES (?,?,?)");
            psts.setString(1, student.getName());
            psts.setString(2, student.getEmail());
            psts.setBoolean(3, student.isGender());
            var res = psts.executeUpdate();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }


}
