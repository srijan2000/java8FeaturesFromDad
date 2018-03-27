package com.venkat.lambda.ex3;

import java.util.function.BiFunction;
import java.util.function.Function;

public class BiFunctionFunction {

    BiFunction<Employee, Manager, Employee> empManagerBiFunction =
                                (emp, manager) -> emp.getManager().getPersonalAssistant();

    Function<Employee, Employee> empManagerFunction = emp -> emp.getManager().getPersonalAssistant();

    private void testBiFunction(Employee emp, Manager manager){
        Employee employee = empManagerBiFunction.apply(emp, manager);
        System.out.println("Employe :" + employee);
    }

    private void testAndThen(Employee emp, Manager manager){

        BiFunction<Employee, Manager, Employee> perAssistant = empManagerBiFunction.andThen(empManagerFunction);
        Employee pa = perAssistant.apply(emp, manager);

    }

    public static void main(String[] args) {
        Employee emp = new Employee(99);
        Manager manager = new Manager();
        emp.setManager(manager);

        manager.setPersonalAssistant(emp);
        BiFunctionFunction bff = new BiFunctionFunction();

        bff.testBiFunction(emp, manager);

        bff.testAndThen(emp, manager);
    }
}
