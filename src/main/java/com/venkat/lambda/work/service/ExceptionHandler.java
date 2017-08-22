package com.venkat.lambda.work.service;

import java.util.function.BiConsumer;

/**
 * Created by venkatram.veerareddy on 8/22/2017.
 */
public class ExceptionHandler {
    public static void main(String[] args){
        int[] nums = {1,3,5,7,9};
        int key = 7;
        process(nums, key, (v,k) -> System.out.println(v + k));
        System.out.println("*******************");

        key = 0;
        process(nums, key, wrapperLambda((v,k) -> System.out.println(v / k)));

    }

    public static void process(int[] nums, int key, BiConsumer<Integer, Integer> consumer){
        for(int i : nums){
            consumer.accept(i, key);
        }
    }

    private static BiConsumer<Integer, Integer> wrapperLambda(BiConsumer<Integer, Integer> consumer){
        return (v,k) -> {
            try {
                consumer.accept(v, k);
            }catch (ArithmeticException e){
                System.out.println("Exception caught...");
            }
        };
    }
}
