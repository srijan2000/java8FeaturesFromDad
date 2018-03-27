package com.venkat.lambda.ex3;

import com.venkat.lambda.ex.Trade;
import com.venkat.lambda.ex.TradeUtil;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

public class PrimitiveStreams {

    List<Trade> trades = TradeUtil.createTrades2();

    private void tradeQuantity(){
        Optional<Integer> quantity =
                trades.stream()
                .map(Trade :: getQuantity)
                .reduce(Integer :: sum);
    }

    private void intStream(){
        int[] ints = new int[]{2,4,6,8,10};
        IntStream intStream = IntStream.of(ints);
        intStream.forEach(System.out::println);
    }

    private void doubleStream(){

    }

    private void convertStreams(){
        int sum = trades.stream().mapToInt(Trade :: getQuantity).sum();
    }

    public static void main(String[] args) {
        PrimitiveStreams ps = new PrimitiveStreams();
        ps.tradeQuantity();
        ps.intStream();
        ps.doubleStream();
    }
}
