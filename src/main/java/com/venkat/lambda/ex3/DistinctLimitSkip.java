package com.venkat.lambda.ex3;

import java.util.List;
import java.util.stream.Stream;

public class DistinctLimitSkip {

    List<Employee> employees = EmployeeUtil.createEmployees();

    private void testDistinct(){

        Stream<String> employeeNamesStream =
                employees
                .stream()
                .map(Employee::getName)
                .distinct();
        employeeNamesStream.forEach(System.out::println);

    }

    private void testLimit(){
        System.out.println("*******************");
        Stream<String> employeeNamesStream =
                employees
                .stream()
                .map(Employee::getName)
                .distinct()
                .limit(3);
        employeeNamesStream.forEach(System.out::println);
    }

    private void testSkip(){
        System.out.println("*******************");
        Stream<String> employeeNamesStream =
                employees
                .stream()
                .skip(3)
                .map(Employee::getName)
                .distinct();
        employeeNamesStream.forEach(System.out::println);
    }

    public static void main(String[] args) {
        DistinctLimitSkip dis = new DistinctLimitSkip();
        dis.testDistinct();
        dis.testLimit();
        dis.testSkip();
    }
}
