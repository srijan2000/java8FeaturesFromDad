package com.venkat.lambda.ex3;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Stats {

    IntStream streamOfInts = IntStream.range(1, 100);

    private void range(){
        IntStream streamOfInts2 = IntStream.rangeClosed(90, 100);
        streamOfInts2.forEach(System.out::println);
    }

    private void testMaxAndMin(){
        IntStream streamOfInts2 = IntStream.rangeClosed(90, 100);
        OptionalInt max = streamOfInts2.max();
        System.out.println("Max: " + max.getAsInt());

        streamOfInts2 = IntStream.rangeClosed(90, 100);
        OptionalInt min = streamOfInts2.min();
        System.out.println("min: " + min.getAsInt());

        streamOfInts2 = IntStream.rangeClosed(90, 100);
        OptionalDouble avg = streamOfInts2.average();
        System.out.println("avg: " + avg.getAsDouble());
    }

    public static void main(String[] args) {
        Stats s = new Stats();
        s.range();
        s.testMaxAndMin();
    }
}
