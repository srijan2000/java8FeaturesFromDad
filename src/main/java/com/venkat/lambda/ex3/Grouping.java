package com.venkat.lambda.ex3;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class Grouping {

    List<Employee> employees = EmployeeUtil.createDetailedEmployees();

    private void groupingByDepartment(){
        Map<String, List<Employee>> empMap = employees.stream().
                collect(groupingBy(e -> e.getDepartment()));

        System.out.println(empMap);
    }

    private void groupingByCity(){
        Map<String, List<Employee>> empMap = employees.stream().
                collect(groupingBy(Employee::getCity));

        System.out.println(empMap);
    }

    private void groupingByDepartmentAndExec(){
        Map<String, Map<String, List<Employee>>> empMap = employees.stream().
                collect(groupingBy((Employee::getDepartment), groupingBy(Employee::getCity)));

        System.out.println(empMap);
    }

    private void groupingByList(){

    }

    private void groiupingByCount(){

    }

    public static void main(String[] args) {
        Grouping g = new Grouping();
        System.out.println("******BY Department********");
        g.groupingByDepartment();
        System.out.println("******BY City********");
        g.groupingByCity();
        System.out.println("******DepartmentAndExec********");
        g.groupingByDepartmentAndExec();
        System.out.println("******BY List********");
        g.groupingByList();
        System.out.println("******By Count********");
        g.groiupingByCount();
    }
}
