package com.venkat.lambda.work.service;

/**
 * Created by venkatram.veerareddy on 8/22/2017.
 */

interface Executable {
    void execute();
}



class Runner {
    public void run(Executable e){
        e.execute();
    }
}
//**********************

interface Add{
    int add(int a, int b);
}

class Adder {
    public void process(Add a){
        int result = a.add(4,5);
        System.out.println("Result is " + result);
    }
}

public class NonLambda {
    public static void main(String[] args){
        Runner r = new Runner();
        r.run(new Executable() {
            @Override
            public void execute() {
                System.out.println("processing ...");
            }
        });

        //Lambda way...
        //anonymous functions, can be assigned to variable, can be passed to functions,
        //can be returned from functions

        System.out.println("***************");
        r.run(()-> System.out.println("Hi there!"));

        System.out.println("***************");
        Adder add = new Adder();
        add.process((a, b) -> a+b);

    }
}
