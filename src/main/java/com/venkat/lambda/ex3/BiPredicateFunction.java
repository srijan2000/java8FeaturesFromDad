package com.venkat.lambda.ex3;

import java.util.function.BiPredicate;

public class BiPredicateFunction {

    BiPredicate<Employee, Manager> empManagerPredicate =
            (emp, manager) -> emp.getManager().equals(manager) ? true : false;

    BiPredicate<Employee, Manager> managerHasAssistantPredicate =
            (emp, manager) -> manager.getPersonalAssistant().equals(emp) ? true : false;

    BiPredicate<Employee, Manager> isPA = empManagerPredicate.and(managerHasAssistantPredicate);

    BiPredicate<Employee, Manager> isPA2 = empManagerPredicate.or(managerHasAssistantPredicate);

    BiPredicate<Employee, Manager> notAManagerPredicate = empManagerPredicate.negate();

    private void testBiPredicate(Employee emp, Manager manager){
        boolean isManager = empManagerPredicate.test(emp, manager);
        System.out.println("Is manager ? " + isManager);
    }

    public static void main(String[] args) {
        BiPredicateFunction bpf = new BiPredicateFunction();

        Employee emp = new Employee(99);
        Manager manager = new Manager();
        emp.setManager(manager);

        bpf.testBiPredicate(emp, manager);
    }
}
