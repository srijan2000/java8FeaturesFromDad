package com.venkat.lambda.work.service;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by venkatram.veerareddy on 8/29/2017.
 */
public class Example2 {
    List<Employee> employees = Arrays.asList(
            new Employee("Venkatram", 50),
            new Employee("Srijan", 18),
            new Employee("Chintu", 24),
            new Employee("Tinku", 26),
            new Employee("Raj", 30));


    public static void main(String[] args){

        Example2 ex = new Example2();

        final List<Employee> collect = ex.employees.stream()
                .filter(Example2::isNotCheck)
                .map(employee -> new Employee(employee.getName(), employee.getAge(), 234232.33))
                .collect(Collectors.toList());
        collect.stream().forEach(System.out::println);


    }

    public static boolean isNotCheck(Employee emp){
        return !emp.getName().equals("Raj");
    }

    static class Employee{

        private String name;
        private int age;
        private double sal;

        public Employee(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public Employee(String name, int age, double sal) {
            this.name = name;
            this.age = age;
            this.sal = sal;
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

        public double getSal() {
            return sal;
        }

        public void setSal(double sal) {
            this.sal = sal;
        }

        @Override
        public String toString() {
            return "Name: " + name + ", age" + age + ", salary: " + sal;
        }
    }
}
