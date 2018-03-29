package com.venkat.lambda.ex3;

import com.venkat.lambda.ex.Trade;
import com.venkat.lambda.ex.TradeUtil;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalType {
    List<Trade> trades = TradeUtil.createTrades2();

    private void attendeesOptional(){

        List<Integer> attendees = Arrays.asList(22,34,56,19);
        Optional<Integer> attendeesOptional =
                attendees.stream().reduce(Integer::sum);

        System.out.println("Sum: " + attendeesOptional.get());

    }

    private void noAttendeesOptional(){
        List<Integer> attendees = Arrays.asList();
        Optional<Integer> attendeesOptional =
                attendees.stream().reduce(Integer::sum);
        if(attendeesOptional.isPresent()) {
            System.out.println("Sum: " + attendeesOptional.get());
        }
    }

    private void creatingOptionals(){
        Student student = new Student();

        Optional<Student> studentOptional = Optional.of(student);
        System.out.println(studentOptional.get());
        studentOptional.ifPresent(System.out::println);

        student = null;
        Optional<Student> studentOptional2 = Optional.ofNullable(student);
        System.out.println("Student can not be null " + studentOptional2);
    }

    private void ifElseOptionals(){
        Student student = null;
        Student defaultStudent = new Student();
        defaultStudent.setName("Defulat John");
        Optional<Student> studentOptional = Optional.ofNullable(student);
        String name = studentOptional.orElse(defaultStudent).getName();
        System.out.println("Get Name: " + name);
    }

    private void ifElseThrowOptionals() throws Exception{
        Student student = null;
        Optional<Student> studentOptional = Optional.ofNullable(student);
        studentOptional.orElseThrow(Exception :: new);
    }

    private void filterMapOptionals(){
        Student st = new Student();
        st.setName("Venkatram Veerareddy");

        Optional<Student> studentOptional = Optional.of(st);
        studentOptional.filter(student -> student.hasTeacher())
                .ifPresent(System.out::println);

        studentOptional.map(s -> s.getName())
                .ifPresent(System.out::println);
    }

    public static void main(String[] args) {

        OptionalType ot = new OptionalType();
        ot.attendeesOptional();
        ot.noAttendeesOptional();
        ot.creatingOptionals();
        ot.ifElseOptionals();
        try {
            ot.ifElseThrowOptionals();
        } catch (Exception e) {
            System.out.println("Exception is thrown.");
        }
        ot.filterMapOptionals();
    }
}
