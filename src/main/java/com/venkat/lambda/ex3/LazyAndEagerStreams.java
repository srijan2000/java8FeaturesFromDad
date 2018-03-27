package com.venkat.lambda.ex3;

import com.venkat.lambda.ex.Movie;
import com.venkat.lambda.ex.MovieUtil;

import java.util.List;
import java.util.stream.Stream;

public class LazyAndEagerStreams {
    List<Movie> movies = MovieUtil.createMovies();

    private void testLazy(){
        movies.stream().filter(m -> {
            System.out.println("Inside lazy operation");
            return m.isClassic();
        }).count();
    }

    private void testEager(){
        Stream<Movie> movieStream =
                movies.stream()
                .filter(m ->{
                    System.out.println("Filtering");
                    return m.isClassic();
                }).map(s -> {
                    System.out.println("Mapping");
                    return s;
                });

        System.out.println(" " + movieStream.count());
    }

    public static void main(String[] args) {
        LazyAndEagerStreams laes = new LazyAndEagerStreams();
        laes.testLazy();
        laes.testEager();
    }
}
