package com.venkat.lambda.ex2;

//check if a movie is classic
interface Movie {
    boolean isClassic(int movieId);
}

interface Person {
    boolean isEmployee(int empId);
}

interface Hospital {
    void admit(Patient patient);
}

interface Tester<T> {
    boolean test(T t);
}

public class WhatAreFunctions {
}
