package com.venkat.lambda.ex4;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lec01ByFunction {

    private static List<Integer> uniqueNums(List<Integer> nums, List<Integer> nums2){
        return Stream.of(nums, nums2)
                .flatMap(List::stream)
                .distinct()
                .collect(Collectors.toList());
    }

    private static BiFunction<List<Integer>, List<Integer>, List<Integer>> uniqueNums2(){
        BiFunction<List<Integer>, List<Integer>, List<Integer>> byF =
                (nums, nums2) -> {
                    return Stream.of(nums, nums2)
                            .flatMap(List::stream)
                            .distinct()
                            .collect(Collectors.toList());
                };
        return byF;
    }

    private static BiFunction<String, Integer, Integer> biF(){

        BiFunction<String, Integer, Integer> incSal = (name, sal) -> sal + 500;
        return incSal;
    }

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 3, 4, 5, 6, 7, 9, 19);
        List<Integer> list2 = List.of(12, 3, 4, 5, 16, 27, 19, 19);

        //System.out.println(uniqueNums(list, list2));

        System.out.println(uniqueNums2().apply(list, list2));

        //salary increase example
        Map<String, Integer> map = new HashMap<>();
        map.put("Venkat", 55000);
        map.put("Ram", 45000);
        map.put("Laxman", 36000);

        map.replaceAll(biF());
        System.out.println(map);
    }
}
