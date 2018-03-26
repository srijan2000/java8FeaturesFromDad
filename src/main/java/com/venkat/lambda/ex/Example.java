package com.venkat.lambda.ex;

public class Example {

    private void process(){
        System.out.println("Processed...");
    }

    private void testRunnable(Runnable runnable){
        new Thread(runnable).start();
    }

    public static void main(String[] args) {
        Example ex = new Example();
        ex.testRunnable(new Runnable() {
            @Override
            public void run() {
                ex.process();
            }
        });

        //java 8 way
        ex.testRunnable(()->ex.process());
    }

}
