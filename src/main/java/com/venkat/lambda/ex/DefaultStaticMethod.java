package com.venkat.lambda.ex;

import java.lang.FunctionalInterface;

@FunctionalInterface
interface Employee {
    //abstract method
    Employee find(int id);

    //default method
    default boolean isExec(int id){
        //find is employee is executive
        return true;
    }

    //static method
    static String getDefaultCountry(){
        return "India";
    }
}

public class DefaultStaticMethod {

    class EmployeeImpl implements Employee{

        @Override
        public Employee find(int id) {
            return null;
        }
    }

    public static void main(String[] args) {

    }
}
