package com.venkat.lambda.ex3;

import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class PrimitiveFunctions {

    //Predicate<Integer> evenNumberPredicate = x -> x%2 == 0;

    IntPredicate evenNumberPredicate = x -> x%2 == 0;

    private void testPredicate(int i){
        for(int j = 1; j <= i; j++){
            if(evenNumberPredicate.test(j)){
                System.out.print(j + "  ");
            }
        }

    }

    public static void main(String[] args) {
        PrimitiveFunctions pf = new PrimitiveFunctions();
        pf.testPredicate(20);
    }
}
