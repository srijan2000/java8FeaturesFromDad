package com.venkat.lambda.ex3;

import java.util.List;
import java.util.stream.Stream;

public class Mapping {

    List<Employee> employees = EmployeeUtil.createEmployees();

    private void testMapping(){

        Stream<Employee> employeeStream = employees.stream();
        employeeStream.forEach(System.out :: println);

        Stream<String> names = employees.stream()
                .map(Employee::getName)
                .map(String::toUpperCase);

        names.forEach(System.out::println);
    }

    public static void main(String[] args) {
        Mapping m = new Mapping();
        m.testMapping();
    }
}
