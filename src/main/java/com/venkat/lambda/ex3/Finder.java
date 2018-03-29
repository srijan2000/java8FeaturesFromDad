package com.venkat.lambda.ex3;

import com.venkat.lambda.ex.Trade;
import com.venkat.lambda.ex.TradeUtil;

import java.util.List;
import java.util.Optional;
//Short Circuit Operators
public class Finder {

    List<Trade> trades = TradeUtil.createTrades2();

    private void testFindFirst(){
        Optional<Trade> firstTrade = trades
                .stream()
                .filter(Trade::isBigTrade)
                .findFirst();

        System.out.println("First trade: " + firstTrade.get());
    }

    private void testFindAny(){
        Optional<Trade> firstTrade = trades
                .stream()
                .filter(Trade::isBigTrade)
                .findAny();

        System.out.println("First trade: " + firstTrade.get());
    }

    private void testAnyMatch(){
        boolean rottenTrade = trades.stream()
                .anyMatch(t->t.getStatus().equals("ROTTEN"));

        System.out.println("Rotten trade :"+ rottenTrade);
    }

    private void testAllMatch(){
        boolean ibmTrade = trades
                .stream()
                .allMatch(t ->t.getInstrument().equals("IBM"));
        System.out.println("Match :" + ibmTrade);
    }

    private void testNoneMatch(){
        boolean cancelledTrade =
                trades.stream().noneMatch(Trade::isCancelledTrade);
        System.out.println("Cancelled trade: " + cancelledTrade);
    }

    public static void main(String[] args) {
        Finder finder = new Finder();
        finder.testFindAny();
        finder.testFindFirst();
        finder.testAnyMatch();
        finder.testAllMatch();
        finder.testNoneMatch();
    }
}
