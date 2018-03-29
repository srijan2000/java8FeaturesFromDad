package com.venkat.lambda.ex3;

import com.venkat.lambda.ex.Trade;
import com.venkat.lambda.ex.TradeUtil;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Reducing {

    List<Trade> trades = TradeUtil.createTrades2();
    List<Integer> ints = Arrays.asList();

    private void tradeInstrumentsList(){
        Optional<String> instList = trades.stream()
                .map(Trade::getInstrument)
                .reduce((a,b) -> a + ", " +b);

        System.out.println(instList.get());
    }

    private void schoolStaff(){
        List<Integer> ints = Arrays.asList(11,13,12,15);
        int staff = ints.stream().reduce(10,(i,j) -> i+j);

        System.out.println("Total staff: " + staff);
    }

    private void tradeQuntitySum(){
        Optional<Integer> instList = trades.stream()
                .map(Trade::getQuantity)
                .reduce((a,b) -> a + b);

        System.out.println(instList.get());
    }

    public static void main(String[] args) {
        Reducing r = new Reducing();
        r.schoolStaff();
        r.tradeQuntitySum();
        r.tradeInstrumentsList();
    }
}
