package com.venkat.lambda.work.service;

/**
 * Created by venkatram.veerareddy on 8/22/2017.
 */
public class MethodReference1 {

    public static void main(String[] args){
        /*Thread t = new Thread(()-> printMsg());
        t.start();*/
        Thread t = new Thread(MethodReference1::printMsg);
        t.start();

    }

    public static void printMsg(){
        System.out.println("Hello");
    }
}
