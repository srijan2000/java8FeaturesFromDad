package com.venkat.lambda.ex3;

import com.venkat.lambda.ex.Trade;
import com.venkat.lambda.ex.TradeUtil;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class CustomCollectors {
    List<Trade> trades = TradeUtil.createTrades2();

    private void collectIntoToCustomCollector2(){
        Supplier<StringBuilder> supplier = StringBuilder::new;

        BiConsumer<StringBuilder, Trade> accumulator =
                (sb, trade) -> sb.append(trade.getInstrument()).append(",");

        BiConsumer<StringBuilder, StringBuilder> combiner =
                (s1, s2) -> s1.append(s2.toString());

        StringBuilder collect = trades.stream().collect(supplier, accumulator, combiner);

        System.out.println(collect);
    }

    private void stats(){

        IntSummaryStatistics s = trades.stream().collect(Collectors.summarizingInt(Trade :: getQuantity));
        System.out.println(s);
    }

    public static void main(String[] args) {
        CustomCollectors cc = new CustomCollectors();
        cc.collectIntoToCustomCollector2();
        cc.stats();
    }
}
