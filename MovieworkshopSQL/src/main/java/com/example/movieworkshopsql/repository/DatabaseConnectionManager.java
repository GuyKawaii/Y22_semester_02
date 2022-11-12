package com.example.movieworkshopsql.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionManager {
    // var
    private static String hostname = "localhost";
    private static String username = "kea";
    private static String password = "pnQvY%d6GgMo";
    private static Connection conn = null;


    // method
    public static Connection getConnection() {
        hostname = "jdbc:mysql://localhost/kea";
        username = "kea";
        password = "pnQvY%d6GgMo";

        try {
            conn = DriverManager.getConnection(hostname, username, password);
            System.out.println("CONNECTION ESTABLISHED");

        } catch (SQLException e) {
            System.out.println("CONNECTION ((NOT)) ESTABLISHED");
            throw new RuntimeException(e);
        }

        return conn;
    }


}
