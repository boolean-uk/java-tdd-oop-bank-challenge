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
        return this.getIntPart()+"."+this.getDecimalPart();
    }

}
