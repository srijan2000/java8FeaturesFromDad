package com.venkat.lambda.work.service;

import com.venkat.lambda.work.entity.Person;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Created by venkatram.veerareddy on 8/22/2017.
 */
public class MethodReference2 {

    public static void main(String[] args){

        List<Person> personList = Arrays.asList(
                new Person("Venkatram", "Veerareddy", 50),
                new Person("Srijan", "Veerareddy", 17),
                new Person("Akhil", "Bandi", 24),
                new Person("Nikhil", "Bandi", 22),
                new Person("James", "Gosling", 40),
                new Person("Martin", "Odersky", 20)
        );

        Collections.sort(personList,(o1, o2) -> o1.getLastName().compareTo(o2.getLastName()));
        printConditionWithPredicate(personList, p -> true, System.out::println);

    }

    public static void printConditionWithPredicate(List<Person> plist, Predicate<Person> condition, Consumer<Person> c){

        for(Person p : plist){
            if(condition.test(p)) {
                c.accept(p);
            }
        }
    }


}
