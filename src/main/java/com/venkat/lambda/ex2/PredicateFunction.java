package com.venkat.lambda.ex2;

import java.util.function.Predicate;

public class PredicateFunction {

    Predicate<Employee> bonusLambda = emp -> emp.getRatings() > 10 ? true : false;
    Predicate<Employee> execLambda = emp -> emp.getId().startsWith("#99") ? true : false;

    Predicate<String> emptyString = s -> s.isEmpty();

    public static void main(String[] args) {

    }
}
