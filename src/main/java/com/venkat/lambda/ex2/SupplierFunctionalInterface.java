package com.venkat.lambda.ex2;

import com.venkat.lambda.ex.Trade;
import com.venkat.lambda.ex.TradeUtil;

import java.util.List;
import java.util.function.Supplier;

public class SupplierFunctionalInterface {

    Supplier<String[]> fruitSupplier = () -> new String[]{"Apple", "Orange"};

    Supplier<List<Trade>> tradeSupplier = () -> TradeUtil.createTrades();

    private void testSupplier(){
        String[] fruits = fruitSupplier.get();
        for(String f: fruits){
            System.out.println("Fruits " + f);
        }

        List<Trade> list = tradeSupplier.get();
        for(Trade t: list){
            System.out.println(t.getStatus());
        }
    }

    public static void main(String[] args) {
        SupplierFunctionalInterface sfi = new SupplierFunctionalInterface();
        sfi.testSupplier();
    }
}
