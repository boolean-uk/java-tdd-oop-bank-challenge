package com.booleanuk.core;

public class Overdraft {
    private String message;
    private double amount;

    Overdraft(String message, double amount){
        this.message = message;
        this.amount = amount;

    }

    protected String getMessage(){
        return this.message;
    }

    protected double getAmount(){
        return this.amount;
    }


}
