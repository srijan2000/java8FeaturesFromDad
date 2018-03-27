package com.venkat.lambda.ex3;

import com.venkat.lambda.ex.Movie;
import com.venkat.lambda.ex.MovieUtil;

import java.util.ArrayList;
import java.util.List;

public class InternalAndExternalIterationStrategy {
    List<Movie> movies = MovieUtil.createMovies();
    List<Movie> top2Classics = new ArrayList<>(10);

    private void testExternalIteration1(){
        for(Movie m : movies){
            if(m.isClassic()){
                top2Classics.add(m);
            }
        }
        System.out.println("Top 2 classics (Ext Iteration): " + top2Classics);
    }

    private void testInternalIteration1(){
        movies.stream()
        .filter(Movie::isClassic)
        .map(Movie::getName)
        .forEach(System.out::println);
    }

    public static void main(String[] args) {
        InternalAndExternalIterationStrategy iaeis = new InternalAndExternalIterationStrategy();
        iaeis.testExternalIteration1();
    }
}
