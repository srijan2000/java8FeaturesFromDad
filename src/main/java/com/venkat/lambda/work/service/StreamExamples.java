package com.venkat.lambda.work.service;

import com.venkat.lambda.work.entity.Person;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by venkatram.veerareddy on 8/22/2017.
 */
public class StreamExamples {

    public static void main(String[] args){

        List<Person> personList = Arrays.asList(
                new Person("Venkatram", "Veerareddy", 50),
                new Person("Srijan", "Veerareddy", 17),
                new Person("Akhil", "Bandi", 24),
                new Person("Nikhil", "Bandi", 22),
                new Person("James", "Gosling", 50),
                new Person("Martin", "Odersky", 40)
        );

        Collections.sort(personList,(o1, o2) -> o1.getLastName().compareTo(o2.getLastName()));
        personList
                .stream()
                .filter(p -> p.getLastName().startsWith("V"))
                .forEach(p -> System.out.println(p.getFirstName()));

    }
}
