package com.venkat.lambda.ex3;

import com.venkat.lambda.ex.Movie;
import com.venkat.lambda.ex.MovieUtil;

import java.util.List;

public class WorkingWithStreams {

    List<Movie> movies = MovieUtil.createMovies();

    private void findMoviesByDirector(String director){
        movies.stream()
                .filter(m -> m.getDirector().equals(director))
                .map(Movie::getName)
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        WorkingWithStreams wws = new WorkingWithStreams();
        wws.findMoviesByDirector("Steven Spielberg");
    }
}
