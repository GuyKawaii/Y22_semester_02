package com.example.movieworkshopsql.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MovieRepository {

    private static Connection conn = DatabaseConnectionManager.getConnection();

    public static void printMovies() {

        try {
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM movie;");
            ResultSet resultSet = preparedStatement.executeQuery();



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


}
