package com.venkat.lambda.ex;

public class TargetType {
    public interface Email {
        String constructEmail(String name);
    }

    public void print(String name, Email email){
        System.out.println(email.constructEmail(name));
    }

    public static void main(String[] args) {
        TargetType tt = new TargetType();
        Email email = (String s) -> s + "@gmail.com"; //type inference
        tt.print("venkat.veerareddy", email);
    }
}
