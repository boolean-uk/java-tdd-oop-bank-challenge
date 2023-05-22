package com.booleanuk.core;

public class UsDollar implements Currency{
    double amount;
    String symbol;
    public UsDollar(double amount){
        this.amount = amount;
        this.symbol = "$";
    }

    @Override
    public double getValue(){return this.amount;};

    @Override
    public String getSymbol(){return this.symbol;}


}
