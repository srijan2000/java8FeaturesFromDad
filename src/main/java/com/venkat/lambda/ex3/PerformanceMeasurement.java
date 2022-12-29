package com.venkat.lambda.ex3;

import com.venkat.lambda.ex.Trade;
import com.venkat.lambda.ex.TradeUtil;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

public class PerformanceMeasurement {

    public void sumTradesInSerial(){
        List<Trade> trades = TradeUtil.createTrades(9000000);
        Instant start = Instant.now();
        //sequential mode
        trades.stream()
        .map(Trade::getQuantity)
        .reduce(Integer::sum);

        Instant end = Instant.now();
        Duration d = Duration.between(start, end);
        System.out.printf("%s %d %s", "Aggregating trades took ", d.toMillis(), " ms in Sequential mode.");
    }

    public void sumTradesInParallel(){
        List<Trade> trades = TradeUtil.createTrades(9000000);
        Instant start = Instant.now();
        //sequential mode
        trades.stream()
                .parallel()
                .map(Trade::getQuantity)
                .reduce(Integer::sum);

        Instant end = Instant.now();
        Duration d = Duration.between(start, end);
        System.out.printf("%s %d %s", "Aggregating trades took ", d.toMillis(), " ms in Parallel mode.");
    }

    public static void main(String[] args) {
        PerformanceMeasurement pm = new PerformanceMeasurement();
        pm.sumTradesInSerial();
        System.out.println("\n**********");
        pm.sumTradesInParallel();
    }
}
