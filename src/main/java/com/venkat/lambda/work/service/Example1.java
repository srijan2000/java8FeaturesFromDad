package com.venkat.lambda.work.service;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Created by venkatram.veerareddy on 8/29/2017.
 */
public class Example1 {

    public static void main(String[] args){
        List<String> names = Arrays.asList("venkat","srijan","vinny","chintu","tinku","siddhu","ranga");

        for (String name : names) {
            System.out.println(name);
        }
        System.out.println("Functional program starts...");
        //Ctrl + P
        /*names.stream()
                .filter(new Predicate<String>() {
                    @Override
                    public boolean test(String name) {
                        return !name.equals("ranga");
                    }
                })
                .forEach(new Consumer<String>() {
                    @Override
                    public void accept(String name) {
                        System.out.println(name);
                    }
                });*/

        printList(names);


    }

    private static void printList(List<String> names) {
        names.stream()
                .filter(isNotName())  //Alt + Enter
                .forEach(getPrintln()); //to extract method Ctrl + Alt + M
    }

    private static Predicate<String> isNotName() {
        return name -> !name.equals("ranga");
    }

    private static Consumer<String> getPrintln() {
        return System.out::println;
    }
}
