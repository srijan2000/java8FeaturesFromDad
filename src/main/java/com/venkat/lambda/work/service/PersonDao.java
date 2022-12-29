package com.venkat.lambda.work.service;

import com.venkat.lambda.work.entity.Person;

import java.util.Arrays;
import java.util.List;

public class PersonDao {
    List<Person> personList = Arrays.asList(
            new Person("Venkatram", "Veerareddy", 50),
            new Person("Srijan", "Veerareddy", 17),
            new Person("Akhil", "Bandi", 24),
            new Person("Nikhil", "Bandi", 22),
            new Person("James", "Gosling", 50),
            new Person("Martin", "Odersky", 40)
    );

    public List<Person> getPersonList(){
        return personList;
    }
}
