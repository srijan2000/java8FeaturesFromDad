package com.venkat.lambda.ex3;

import java.util.List;
import java.util.stream.Stream;

public class Filtering {

    List<Employee> employees = EmployeeUtil.createEmployees();
    private void testFiltering(){
        Stream<Employee> employeeStream = employees
                .stream()
                .filter(Employee::isSenior)
                .filter(Employee::isExecutive);
        employeeStream.forEach(System.out::println);
    }

    public static void main(String[] args) {
        Filtering f = new Filtering();
        f.testFiltering();
    }
}
