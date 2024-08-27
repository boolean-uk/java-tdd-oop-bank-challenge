package com.booleanuk.core;

import java.util.Date;

public class Transaction {

    private int amount;
    private Date date;

    public Transaction(int amount) {
        this.setAmount(amount);
        this.setDate(new Date());
    }


    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
