package com.venkat.lambda.work.service;

/**
 * Created by venkatram.veerareddy on 8/22/2017.
 */
public class ThisReferenceExample {
    public void doProcess(int i, Process p){
        p.process(i);
    }

    public void execute(){
        System.out.println(this);//this will work
        doProcess(10, i -> {
            System.out.println("Value of i is " + i);
            System.out.println(this);//this will work
        });
    }


    public static void main(String[] args){
        ThisReferenceExample thisReferenceExample = new ThisReferenceExample();
        thisReferenceExample.doProcess(10, new Process() {
            @Override
            public void process(int i) {
                System.out.println("Value of i is " + i);
                System.out.println(this);
            }

            public String toString(){
                return "This is annonymous inner class";
            }
        });

        thisReferenceExample.doProcess(10, i -> {
            System.out.println("Value of i is " + i);
            //System.out.println(this);//this will not work
        });

        thisReferenceExample.execute();

    }
}
