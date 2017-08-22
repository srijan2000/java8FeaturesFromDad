package com.venkat.lambda.work.service;

/**
 * Created by venkatram.veerareddy on 8/21/2017.
 */
public class GreetService {

    public static void main(String[] args) {
        IGreet greet = (String s) -> "Hello, " + s; //this is the lambda expresstion
        System.out.println(greet.greet("Srijan"));

        printGreeting(s -> "Hello, " + s);

        //Thread Example
       /* Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread started and ended...");
            }
        });
        thread.start();*/
        //lambda expression
        Thread thread = new Thread(() -> System.out.println("Thread started and ended..."));
        thread.start();
    }

    public static void printGreeting(IGreet greet){
        System.out.println(greet.greet("Venkatram"));
    }
}
