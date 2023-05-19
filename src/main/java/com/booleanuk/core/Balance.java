package com.booleanuk.core;

public class Balance {
    private int intPart, decimalPart;
    public Balance(int intPart, int decimalPart){
        this.intPart = intPart;
        this.decimalPart = decimalPart;
    }
    public int getIntPart(){
        return this.intPart;
    }
    public int getDecimalPart(){
        return this.decimalPart;
    }
    @Override
    public String toString(){
        return this.getIntPart()+","+this.getDecimalPart();
    }
    //the interact method will either add or remove(if the balance is positive or negative) balances
    public void interact(Balance balance){
        this.intPart += balance.getIntPart();
        this.decimalPart += balance.getDecimalPart();
    }

}
