package com.venkat.lambda.ex3;

import com.venkat.lambda.ex.Actor;
import com.venkat.lambda.ex.Movie;
import com.venkat.lambda.ex.MovieUtil;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class FlattenMapEx {

    List<Movie> movies = MovieUtil.createMoviesAndActors();
    String[] fruits = new String[]{"apples", "oranges"};
    String[] veggies = new String[]{"beans", "peas"};

    private void flatMapMovies(){

        Stream<Actor> actorStream =
                movies.stream().flatMap(m -> m.getActors().stream());

        actorStream.forEach(System.out::println);

    }

    private void flatMapVeggies(){
        Stream<List<String>> fruitsAndVeggies =
                Stream.of(Arrays.asList(fruits), Arrays.asList(veggies));

        fruitsAndVeggies.flatMap(s -> s.stream())
                .forEach(System.out::println);
    }

    public static void main(String[] args) {

        FlattenMapEx fm = new FlattenMapEx();
        fm.flatMapVeggies();
        fm.flatMapMovies();
    }
}
