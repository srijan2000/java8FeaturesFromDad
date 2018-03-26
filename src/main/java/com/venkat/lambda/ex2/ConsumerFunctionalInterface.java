package com.venkat.lambda.ex2;

import com.venkat.lambda.ex.Movie;

import java.util.function.Consumer;

public class ConsumerFunctionalInterface {

    Consumer<Movie> pritInfo = m -> System.out.println("Printing out movie info: " + m);

    Consumer<Movie> persistMovie = m -> persist(m);


    private void testConsumer(Movie movie){
        pritInfo.accept(movie);
        persistMovie.accept(movie);
    }

    private void testAndThen(Movie movie){
        Consumer<Movie> printAndPersistMovie = pritInfo.andThen(persistMovie);
        printAndPersistMovie.accept(movie);
    }

    private void persist(Movie m){
        System.out.println("Persisting movie " + m);
    }

    public static void main(String[] args) {
        Movie movie = new Movie("Gods Must Be Crazy");
        ConsumerFunctionalInterface cfi = new ConsumerFunctionalInterface();
        cfi.testConsumer(movie);
        cfi.persist(movie);
        cfi.testAndThen(movie);
    }
}
