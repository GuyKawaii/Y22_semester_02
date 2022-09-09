package com.example.movieworkshop.repository;

import com.example.movieworkshop.model.Movie;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class MovieRepository {
    private List<Movie> movies = new ArrayList<Movie>();

    public void generateMoviesList() {
        // add movie obj from csv
        try {
            Scanner input = new Scanner(new File("C:\\Users\\danie\\OneDrive\\KEA\\IdeaProjects\\Y22_semester_02\\Movieworkshop\\src\\main\\resources\\movie.csv"));
            input.useDelimiter(";");

            // skip header
            input.nextLine();

            while (input.hasNextLine()) {
                String line = input.nextLine();
                Scanner token = new Scanner(line).useDelimiter(";").useLocale(Locale.ENGLISH);

                //  Year;Length;Title;Subject;Popularity;Awards
                while (token.hasNext()) {
                    // get attributes
                    int year = Integer.parseInt(token.next());
                    int length = Integer.parseInt(token.next());
                    String title = token.next();
                    String subject = token.next();
                    int popularity = Integer.parseInt(token.next());
                    Boolean hasAwards = token.next().equals("Yes");

                    // add attributes
                    movies.add(new Movie(year, length, title, subject, popularity, hasAwards));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Movie getOne(int index) {
        return movies.get(index);
    }

    public int getSize() {
        return movies.size();
    }

    public List<Movie> getMovies() {
        return movies;
    }


}
