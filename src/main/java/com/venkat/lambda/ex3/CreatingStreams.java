package com.venkat.lambda.ex3;

import com.venkat.lambda.ex.Movie;
import com.venkat.lambda.ex.MovieUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class CreatingStreams {

    private void testCollectionStreams(){
        List<Movie> movies = MovieUtil.createMovies();

        movies.stream().forEach(System.out::println);
    }

    private void testEmptyStreams(){
        Stream<Movie> movieStream = Stream.empty();
        System.out.println("Empty stream: " + movieStream.count());
    }

    private void testStreamsFromValues(){
        Stream<String> movieNames = Stream.of("Gods Must Be Crazy", "Fiddler On The Roof");
        System.out.println(movieNames.count());

        String[] movieName2 = {"Gods Must Be Crazy", "Fiddler On The Roof"};
        Stream<String> mNames = Stream.of(movieName2);
    }

    private void testFileStream(){
        Stream<String> fileLines = null;
        try {
            fileLines = Files.lines(Paths.get(""));
        } catch (IOException e) {
            e.printStackTrace();
        }
        fileLines.forEach(System.out::println);
    }

    private void testGenerateIterateStreams(){
        Stream<Double> randomStream = Stream.generate(Math::random);
        //randomStream.forEach(System.out::println);

        Stream<Integer> wholeNumbers = Stream.iterate(1, i -> i + 1);
        wholeNumbers.forEach(System.out::println);
    }

    public static void main(String[] args) {
        CreatingStreams cs = new CreatingStreams();
        cs.testEmptyStreams();
        cs.testStreamsFromValues();
        cs.testCollectionStreams();
        cs.testGenerateIterateStreams();
        cs.testFileStream();
    }
}
