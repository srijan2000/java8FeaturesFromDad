package com.venkat.lambda.ex;

import java.lang.FunctionalInterface;

public class FunctionalInterfaceAnnotation {

    @FunctionalInterface
    interface Cruncher {
        int crunch(int i, int j);
    }

    public int cruncherService(int i, int j, Cruncher crucher){
        return crucher.crunch(i, j) ;
    }

    public static void main(String[] args) {

        FunctionalInterfaceAnnotation fia = new FunctionalInterfaceAnnotation();
        int result = fia.cruncherService(12,6, (p,q) -> p * q);
        System.out.println(result);

        result = fia.cruncherService(12,6, (p,q) -> p + q);
        System.out.println(result);

        result = fia.cruncherService(12,6, (p,q) -> p - q);
        System.out.println(result);

        result = fia.cruncherService(12,6, (p,q) -> p / q);
        System.out.println(result);
    }
}
