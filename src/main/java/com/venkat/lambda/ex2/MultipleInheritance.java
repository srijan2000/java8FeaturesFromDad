package com.venkat.lambda.ex2;

//Multiple Inheritance
interface Engine {
    default String model(int id){
        return "DEFAULT ENGINE";
    }
}

class Car implements Engine {
    String getModel(int id){
        return model(id);
    }
}

interface Vehicle {
    default String model(int id){
        return "DEFAULT ENGINE";
    }
}


public class MultipleInheritance {

    public static void main(String[] args) {
        MultipleInheritance mi = new MultipleInheritance();
    }
}
