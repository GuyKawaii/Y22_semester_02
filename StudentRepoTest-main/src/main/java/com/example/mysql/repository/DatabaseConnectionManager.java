package com.example.mysql.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionManager {
    private static String hostname;
    private static String username;
    private static String password;
    private static Connection conn;

    public static Connection getConnection(){
        if(conn != null){
            return conn;
        }
        hostname = "jdbc:mysql://localhost:3306/kea";
        username = "kea";
        password = "pnQvY%d6GgMo";
        try {
            conn = DriverManager.getConnection(hostname, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
