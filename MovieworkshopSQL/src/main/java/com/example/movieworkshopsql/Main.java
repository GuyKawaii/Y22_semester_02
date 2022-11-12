package com.example.movieworkshopsql;

import com.example.movieworkshopsql.repository.DatabaseConnectionManager;
import com.example.movieworkshopsql.repository.StudentRepository;

public class Main {
    public static void main(String[] args) {
        DatabaseConnectionManager.getConnection();

        StudentRepository studentRepository = new StudentRepository();
        System.out.println(studentRepository.getAllStudents());



    }
}
