package com.venkat.lambda.ex;

public class ArrayReference {

    interface StringArray {
        String[] create(int size);
    }

    private void testArrayConstructorRef(){
        StringArray stringArray = (size) -> new String[size];

        //or
        StringArray stringArray1 = String[]::new;

    }

    public static void main(String[] args) {
        ArrayReference ar = new ArrayReference();
    }
}
