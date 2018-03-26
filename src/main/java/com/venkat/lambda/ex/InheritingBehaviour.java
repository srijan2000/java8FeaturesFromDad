package com.venkat.lambda.ex;

interface Engine {

    default String make(){
        return "DEFAULT MAKE";
    }
}

interface Vehicle {

    default String model(){
        return "DEFAULT MODEL";
    }
}

class Car implements Engine, Vehicle {

    String makeAndMode(){
        return Engine.super.make() + Vehicle.super.model();
    }
}

public class InheritingBehaviour {
    public static void main(String[] args) {
        InheritingBehaviour ib = new InheritingBehaviour();
    }
}
