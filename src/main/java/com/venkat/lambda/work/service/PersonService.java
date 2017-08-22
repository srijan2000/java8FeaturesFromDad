package com.venkat.lambda.work.service;

import com.venkat.lambda.work.entity.Person;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Created by venkatram.veerareddy on 8/21/2017.
 */
public class PersonService {

    public static void printPersonsJ7(List<Person> plist){

        Collections.sort(plist, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getLastName().compareTo(o2.getLastName());
            }
        });

        for(Person p : plist){
            System.out.println(p);
        }
    }

    /*public static void printCondition(List<Person> plist){
        System.out.println("**********************");

        for(Person p : plist){
            if(p.getLastName().startsWith("B"))
                System.out.println(p);
        }

    }*/

    public static void printCondition(List<Person> plist, Condition condition){
        System.out.println("**********************");

        for(Person p : plist){
            if(condition.test(p))
                System.out.println(p);
        }

    }

    public static void printPersonsJ8(List<Person> plist){

        Collections.sort(plist,(o1, o2) -> o1.getLastName().compareTo(o2.getLastName()));

        plist.forEach(System.out::println);

    }

    public static void printConditionWithPredicate(List<Person> plist, Predicate<Person> condition){
        System.out.println("**********************");

        for(Person p : plist){
            if(condition.test(p))
                System.out.println(p);
        }

    }

    public static void printConditionWithPredicate(List<Person> plist, Predicate<Person> condition, Consumer<Person> c){
        System.out.println("**********************");

        for(Person p : plist){
            if(condition.test(p))
                //System.out.println(p);
                c.accept(p);
        }

    }



    public static void main(String[] args){
        List<Person> personList = Arrays.asList(
                new Person("Venkatram", "Veerareddy", 50),
                new Person("Srijan", "Veerareddy", 17),
                new Person("Akhil", "Bandi", 24),
                new Person("Nikhil", "Bandi", 22),
                new Person("James", "Gosling", 40),
                new Person("Martin", "Odersky", 20)
        );
        //printPersonsJ7(personList);
        printPersonsJ8(personList);
        //printCondition(personList);

        Condition c =  p -> p.getLastName().startsWith("B");

        printCondition(personList, c);

        Predicate<Person> c2 =  p -> p.getLastName().startsWith("V");

        //printConditionWithPredicate(personList, c2);
        printConditionWithPredicate(personList, c2, p -> System.out.println(p.getFirstName()));

    }
}

interface Condition{
    boolean test(Person p);
}
