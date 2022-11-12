package com.example.mysql.repository;

import com.example.mysql.model.Student;

public class test {
    public static void main(String[] args) {
        StudentRepository stuRepo = new StudentRepository();

        System.out.println(stuRepo.getAllStudents());
        System.out.println(stuRepo.getStudent(2));
    }
}
