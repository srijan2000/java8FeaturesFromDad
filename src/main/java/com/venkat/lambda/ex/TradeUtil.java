package com.venkat.lambda.ex;

import java.util.ArrayList;
import java.util.List;

public class TradeUtil {

    public static List<Trade> createTrades(){
        List<Trade> list = new ArrayList<>();
        Trade t1 = new Trade("GOOG", 200000,"CANCEL");
        list.add(t1);
        t1 = new Trade("IBM", 20000,"OPEn");
        list.add(t1);
        return list;
    }

    public static List<Trade> createTrades2(){
        List<Trade> list = new ArrayList<>();
        Trade t1 = new Trade(101,"GOOG", 200000,"CANCEL");
        list.add(t1);
        t1 = new Trade(102,"IBM", 20000,"OPEn");
        list.add(t1);
        return list;
    }
}
