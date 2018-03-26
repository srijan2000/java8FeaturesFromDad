package com.venkat.lambda.ex;

import java.awt.*;

interface IMovie{
    public boolean check(int id);
}
public class MethodReference {

    public static boolean isClassic(int movieId){
        return true;
    }

    public void testMovieStaticMethodRef(){
        IMovie m1 = (i) -> i < 100 ? true : false;
        IMovie m2 = MethodReference :: isClassic;
    }

    private void testMovieInstanceMethodRef(){
        MethodReference ref = new MethodReference();
        IMovie m1 = (i) -> i > 10 && i < 100 ? true : false;
        IMovie m2 = ref :: isTop10;
    }

    public boolean isTop10(int movieId){
        return true;
    }

    private void testMovieArbitraryObjectMethodRef(){
        IMovie m = SomeMethodReference :: isCamedy;
    }

    public static void main(String[] args) {
        MethodReference mr = new MethodReference();
    }
}

class SomeMethodReference {
    public static boolean isCamedy(int i){
        return false;
    }
}
