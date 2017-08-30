package com.venkat.lambda.work.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by venkatram.veerareddy on 8/29/2017.
 */
public class Example5 {

    public static void main(String[] args) throws IOException {
        final List<String> collect = Files.lines(Paths.get("D:/work/srijan/java8Features/pom.xml"))
                .filter(line -> line.contains("name"))
                .map(line -> {
                    return line.replaceAll("name", "")
                            .replaceAll("<", "")
                            .replaceAll(">", "")
                            .replaceAll("/", "");

                })
                .collect(Collectors.toList());
        System.out.println(collect);

    }


}
