package com.venkat.lambda.ex;

public class LambdaEx {
    interface Greeting{
        public String greet(String s);
    }

    public void sayHello(String s, Greeting g){
        String result = g.greet(s);
        System.out.println(result);
    }

    public static void main(String[] args) {
        LambdaEx ex = new LambdaEx();
        ex.sayHello("Venkatram",(String s) -> "Hello, " + s);

        ex.sayHello("",(String s) -> !s.isEmpty() ? "Hello, " + s : "Name should not be empty.");
    }
}
