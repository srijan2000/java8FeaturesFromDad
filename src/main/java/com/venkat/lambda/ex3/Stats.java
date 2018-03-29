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
        OptionalInt max = streamOfInts.max();
        System.out.println("Max: " + max.getAsInt());

        OptionalInt min = streamOfInts.min();
        System.out.println("min: " + min.getAsInt());

        OptionalDouble avg = streamOfInts.average();
        System.out.println("avg: " + avg.getAsDouble());
    }

    public static void main(String[] args) {
        Stats s = new Stats();
        s.range();
        s.testMaxAndMin();
    }
}
