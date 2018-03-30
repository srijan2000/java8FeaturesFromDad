package com.venkat.lambda.ex3;

import com.venkat.lambda.ex.Trade;
import com.venkat.lambda.ex.TradeUtil;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class ParallelStreams {

    List<Trade> trades = TradeUtil.createTrades2();

    private void serialStream(){

        Optional<Integer> sumOfTrades =
                trades.stream()
                .filter(t -> {
                    System.out.printf("Id: %d Filter Thread: %s: \n",t.getId(), Thread.currentThread().getName());
                    return t.isBigTrade();
                }).map(t -> {
                    System.out.printf("Id: %d Map Thread: %s: \n", t.getId(),Thread.currentThread().getName());
                    return t.getQuantity();
                }).reduce(Integer::sum);
        System.out.println(sumOfTrades.get());
    }

    private void parallelStream(){
        Optional<Integer> sumOfTrades = trades.stream()
                .parallel()
                .filter(Trade::isBigTrade)
                .peek(t-> System.out.printf("Trade Id=%d(Filter Thread Name=%s)\n", t.getId(), Thread.currentThread().getName()))
                .map(t->t.getQuantity())
                .peek(t-> System.out.printf("(Mapper Thread Name=%s)\n", Thread.currentThread().getName()))
                .reduce(Integer::sum);

        System.out.println(sumOfTrades.get());
    }

    private void collectionParallelStream(){
        Stream<Trade> parallelStreams = trades.parallelStream();
    }


    public static void main(String[] args) {
        ParallelStreams ps = new ParallelStreams();
        //ps.serialStream();
        ps.parallelStream();
    }
}
