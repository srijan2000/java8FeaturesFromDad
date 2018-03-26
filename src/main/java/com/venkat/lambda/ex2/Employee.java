package com.venkat.lambda.ex2;

public class Employee {

    private String id;
    private int rating;

    public Employee(String id, int rating){
        this.id = id;
        this.rating = rating;
    }
    public int getRatings(){
        return rating;
    }

    public String getId(){
        return id;
    }
}
