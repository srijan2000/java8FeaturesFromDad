package com.venkat.lambda.ex2;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

import com.venkat.lambda.ex.Movie;
import com.venkat.lambda.ex.Trade;
import com.venkat.lambda.ex.TradeUtil;

public class FunctionFunctionalInterface {

    Function<String, Movie> createMovieFunction = s -> new Movie(s);

    List<Trade> trades = TradeUtil.createTrades2();

    Supplier<List<Trade>> tradeSupplier = () -> TradeUtil.createTrades2();

    Function<Integer, Trade> tradeFinder = id -> {
        for(Trade trade: trades){
            if(trade.getId() == id){
                return trade;
            }
        }
        return new Trade();
    };

    Function<Integer, Trade> tradeFinder2 = id -> {
        List<Trade> trades = tradeSupplier.get();
        return trades.stream()
                .filter(t -> t.getId() == id)
                .findFirst()
                .get();
    };

    private void testFunction(String name){
        Movie m = createMovieFunction.apply(name);
        System.out.println(m);
        Trade t = tradeFinder.apply(102);
        System.out.println(t);

        t = tradeFinder2.apply(101);

        System.out.println(t);
    }

    public static void main(String[] args) {
        FunctionFunctionalInterface ffi = new FunctionFunctionalInterface();

        ffi.testFunction("Sri");
    }
}
