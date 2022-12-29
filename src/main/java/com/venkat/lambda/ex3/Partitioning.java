package com.venkat.lambda.ex3;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Partitioning {
    List<Employee> employees = EmployeeUtil.createDetailedEmployees();

    private void partitionByExecutives(){

        Map<Boolean, List<Employee>> booleanListMap =
                employees.stream().collect(Collectors.partitioningBy(Employee::isExecutive));
        System.out.println(booleanListMap);
    }

    private void partitioningAndGrouping() {

        Map<Boolean, Map<String, List<Employee>>> mapMap = employees.stream()
                .collect(Collectors.partitioningBy((Employee::isExecutive), Collectors.groupingBy(Employee::getDepartment)));

        for(Boolean b : mapMap.keySet()){
            System.out.println(b + " ---> " + mapMap.get(b));
        }


    }

    private void partitioningMultiLevel(){
        Map<Boolean, Map<Boolean, List<Employee>>> execEmps = employees.stream()
                .collect(Collectors.partitioningBy((Employee::isExecutive), Collectors.groupingBy(Employee::isSenior)));

        for(Boolean b : execEmps.keySet()){
            System.out.println(b + " ---> " + execEmps.get(b));
        }
    }

    public static void main(String[] args) {
        Partitioning p = new Partitioning();
        System.out.println("*************");
        p.partitionByExecutives();
        System.out.println("*************");
        p.partitioningAndGrouping();
        System.out.println("*************");
        p.partitioningMultiLevel();
    }
}
