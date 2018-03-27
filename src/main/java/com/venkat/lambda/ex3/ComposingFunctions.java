package com.venkat.lambda.ex3;

import java.util.function.Function;

public class ComposingFunctions {
    Function<Employee, Manager> managerFinder = (emp) -> getManager(emp);
    Function<Manager, Employee> assistantFinder = (manager) -> getPersonalAssistant(manager);

    private void testAndThen(Employee emp){
        Function<Employee, Employee> empManagerAssistantFinder =
                managerFinder.andThen(assistantFinder);
    }

    private void testCompose(Employee emp){
        Function<Employee, Employee> empFinder = assistantFinder.compose((managerFinder));

    }

    private Manager getManager(Employee emp){
        return emp.getManager();
    }

    private Employee getPersonalAssistant(Manager manager){
        return manager.getPersonalAssistant();
    }

    public static void main(String[] args) {
        ComposingFunctions cf = new ComposingFunctions();
    }
}
