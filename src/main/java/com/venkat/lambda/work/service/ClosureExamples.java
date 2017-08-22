package com.venkat.lambda.work.service;

/**
 * Created by venkatram.veerareddy on 8/22/2017.
 */
public class ClosureExamples {
    public static void main(String[] args){
        int a = 10;
        int b = 20;//since java 8, if java 7 make it final
        doProcess(a, (int i) -> System.out.println(i + b));
        /*doProcess(a, new Process(){
            @Override
            public void process(int i) {
                System.out.println(i + b);
            }
        });*/
    }

    public static void doProcess(int i, Process p){
        p.process(i);
    }
}

interface Process {
    void process(int i);
}
