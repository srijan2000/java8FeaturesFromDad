package com.venkat.lambda.ex;

public class CapturingLambda {

    Trade trade = new Trade("IBM", 12345,"Open");

    public interface ITrade{
        public boolean check(Trade t);
    }

    public boolean isOpenTrade(){
        ITrade simpleLamda = (t) -> t.isOpen() ? true : false;
        return simpleLamda.check(trade);
    }

    public boolean checkStatus(String status){
        ITrade statusLamda = (t) -> t.getStatus().equals(status) ? true : false; //capturing lambda
        return statusLamda.check(trade);
    }

    public boolean isOpenAndBig(String status, int quantity){
        ITrade openAndLargeTradeLambda = (t) -> {
            return (t.getStatus().equals(status) && t.getQuantity() > quantity) ? true : false; //capturing lambda
        };
        return openAndLargeTradeLambda.check(trade);
    }

    public static void main(String[] args) {
        CapturingLambda cl = new CapturingLambda();
    }
}
