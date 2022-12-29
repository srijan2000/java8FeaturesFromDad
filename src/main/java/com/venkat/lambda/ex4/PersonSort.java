package com.venkat.lambda.ex4;

import com.venkat.lambda.work.entity.Person;
import com.venkat.lambda.work.service.PersonDao;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PersonSort {

    public static void main(String[] args) {

        PersonDao personDao = new PersonDao();
        List<Person> personList = personDao.getPersonList();
        System.out.println("*****Ascending*********");
        Collections.sort(personList, (o1, o2) -> o1.getLastName().compareTo(o2.getLastName()));
        personList.forEach(System.out::println);
        System.out.println("*****Descending*********");
        Collections.sort(personList, (o1, o2) -> o2.getLastName().compareTo(o1.getLastName()));
        personList.forEach(System.out::println);

        System.out.println("*********With Age**********");
        personList.stream().sorted(Comparator.comparing(p -> p.getAge()))
                .forEach(System.out::println);
    }
}
