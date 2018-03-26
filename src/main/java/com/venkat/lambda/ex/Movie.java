package com.venkat.lambda.ex;

public class Movie {

    private String name;

    public Movie(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return  this.name;
    }
}
