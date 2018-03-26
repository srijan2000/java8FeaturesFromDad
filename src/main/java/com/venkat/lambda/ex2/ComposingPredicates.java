package com.venkat.lambda.ex2;

import com.venkat.lambda.ex.Trade;
import com.venkat.lambda.ex.TradeUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ComposingPredicates {

    private void testPredicate() {

        //logical and
        Predicate<Trade> bigTrade = t -> t.isBigTrade();
        Predicate<Trade> cancelledTrade = t -> t.isCancelledTrade();

        Predicate<Trade> bigAndCancelledTrade = t -> t.isBigTrade() && t.isCancelledTrade();

        Predicate<Trade> getBigAndCancelledTrade2 = bigTrade.and(cancelledTrade);

        Predicate<Trade> issuerTrade = t -> t.getInstrument().equals("GOOG");

        Predicate<Trade> bingCancelledTradeForGoogleIssuer = getBigAndCancelledTrade2.and(issuerTrade);
        //logical or
        Predicate<Trade> newTrade = t -> t.getStatus().equals("NEW");

        Predicate<Trade> cancelTrade = t -> t.getStatus().equals("CANCEL");

        Predicate<Trade> newOrCancelTrade = newTrade.or(cancelledTrade);

        //logical and or

        Predicate<Trade> newOrCancelledButBigTrade = newTrade.or(cancelledTrade).and(bigTrade);

        //negate
        Predicate<Trade> notNewTrade = newTrade.negate();
        //equals
        Trade t1 = new Trade("GOOG", 200000, "CANCEL");
        List<Trade> tList = TradeUtil.createTrades();


        Predicate<Trade> p1 = Predicate.isEqual(t1);

        for (Trade t : tList) {
            if(p1.test(t)){
                System.out.println("Matching trade: " + t);
            }
        }
    }

    public static void main(String[] args) {
        ComposingPredicates cp = new ComposingPredicates();
    }
}
