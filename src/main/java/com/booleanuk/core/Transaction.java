package com.booleanuk.core;

public class Transaction {

    private int amount;

    public Transaction(int amount) {
        this.setAmount(amount);
    }


    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
