package com.venkat.lambda.ex;

public class Trade {

    private String ticker;
    private String status;
    private int quantity;
    private int id;


    public Trade(){}

    public Trade(String ticker, int quantity, String status){
        this.ticker = ticker;
        this.quantity = quantity;
        this.status = status;
    }

    public Trade(int id, String ticker, int quantity, String status){
        this(ticker,quantity,status);
        this.id = id;
    }

    public String getStatus(){
        return this.status;
    }

    public boolean isOpen(){
        return this.status == "Open";
    }

    public int getQuantity(){
        return this.quantity;
    }

    public String getTicker(){
        return this.ticker;
    }

    public boolean isCancelledTrade(){
        return true;
    }

    public boolean isBigTrade(){
        return true;
    }

    public String getInstrument(){
        return this.ticker;
    }

    public int getId(){
        return this.id;
    }
}
