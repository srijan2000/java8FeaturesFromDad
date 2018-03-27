package com.venkat.lambda.ex3;

import com.venkat.lambda.ex.Trade;
import com.venkat.lambda.ex.TradeUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamBasics {


    private void findLargeTradeUsingStreams(List<Trade> trades){
        List<Trade> largeTrades = trades.stream()
                .filter(trade -> trade.getQuantity() > 10000)
                .collect(Collectors.toList());

        System.out.println("Large trades: " + largeTrades);
    }

    private List<Trade> findLargeTradesUsingPreJava8(List<Trade> trades){
        List<Trade> largeTrades = new ArrayList<Trade>();
        for(Trade trade: trades){
            if(trade.getQuantity() > 10000){
                largeTrades.add(trade);
            }
        }

        return largeTrades;
    }

    public static void main(String[] args) {
        StreamBasics sb = new StreamBasics();

        List<Trade> trades = TradeUtil.createTrades2();
        sb.findLargeTradesUsingPreJava8(trades);
    }
}
