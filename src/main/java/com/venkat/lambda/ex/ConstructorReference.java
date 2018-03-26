package com.venkat.lambda.ex;

public class ConstructorReference {

    class Movie {
        public Movie(int id){

        }

        public Movie(int id, String name){

        }
    }

    interface MovieFactory{
        public Movie create(int id);
    }

    MovieFactory m1 = i -> new Movie(i);

    //or
    MovieFactory m2 = Movie::new; //context so one parameter constructor is called.

    interface MovieFactory2{
        public Movie create(int id, String s);
    }

    MovieFactory2 m3 = Movie::new;

    public static void main(String[] args) {
        ConstructorReference cr = new ConstructorReference();

        //ArrayList :: new
    }
}
