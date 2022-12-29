package com.venkat.lambda.ex4;

import java.util.*;

public class Lec02Map {

    public static void main(String[] args) {
        //ex1();
        ex2();
    }

    private static void ex2() {
        Map<String, Integer> map = new HashMap<>();
        map.put("Venkat", 55000);
        map.put("Laxman", 36000);
        map.put("Ram", 45000);


       map.entrySet().stream().sorted(Map.Entry.comparingByKey())
               .forEach(System.out::println);
    }

    private static void ex1() {
        Map<String, Integer> map = new HashMap<>();
        map.put("Venkat", 55000);
        map.put("Laxman", 36000);
        map.put("Ram", 45000);


        List<Map.Entry<String, Integer>> entries = new ArrayList<>(map.entrySet());

        Collections.sort(entries, (o1,o2) -> o1.getKey().compareTo(o2.getKey()));

        for(Map.Entry<String, Integer> entry : entries){
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
}
