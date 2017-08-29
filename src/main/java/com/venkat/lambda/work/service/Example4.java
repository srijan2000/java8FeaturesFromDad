package com.venkat.lambda.work.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by venkatram.veerareddy on 8/29/2017.
 */
public class Example4 {
    List<Employee> employees = Arrays.asList(
            new Employee("Venkatram", 50,Arrays.asList("123 123 123", "231 231 231")),
            new Employee("Srijan", 18,Arrays.asList("123 222 123", "231 111 231")),
            new Employee("Chintu", 24,Arrays.asList("123 153 123", "231 888 231")),
            new Employee("Tinku", 26,Arrays.asList("123 143 123", "231 999 231")),
            new Employee("Raj", 30,Arrays.asList("123 133 123", "231 000 231")));


    public static void main(String[] args){

        Example4 ex = new Example4();

       /* Optional<Object> any = ex.employees.stream()
                .map(employee -> employee.getPhoneNumbers().stream())
                .flatMap(new Function<Stream<String>, Stream<?>>() {
                    @Override
                    public Stream<?> apply(Stream<String> stringStream) {
                        return stringStream.filter(phoneNo -> phoneNo.equals("231 111 231"));
                    }
                })
                .findAny();*/

        Optional<String> any = ex.employees.stream()
                .map(employee -> employee.getPhoneNumbers().stream())
                .flatMap( stringStream -> stringStream.filter(phoneNo -> phoneNo.equals("231 111 231")))
                .findAny();

        any.ifPresent(System.out::println);



    }


    static class Employee{

        private String name;
        private int age;
        private List<String> phoneNumbers;


        public Employee(String name, int age, List<String> phoneNumbers) {
            this.name = name;
            this.age = age;
            this.phoneNumbers = phoneNumbers;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public List<String> getPhoneNumbers() {
            return phoneNumbers;
        }

        public void setPhoneNumbers(List<String> phoneNumbers) {
            this.phoneNumbers = phoneNumbers;
        }

        @Override
        public String toString() {
            String emp =  "Name: " + name + ", age" + age + ", phone list : " ;
            for (String phoneNumber : phoneNumbers) {
                emp += phoneNumber +", ";
            }
            return emp;
        }
    }
}
