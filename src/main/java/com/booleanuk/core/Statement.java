package com.booleanuk.core;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class Statement {
    private Date date;
    private double amount;
    private int balance;

    public Statement (double amount, int balance) {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.date = new Date();
        this.amount = amount;
        this.balance = balance;
    }

    public Date getDate() {
        return this.date;
    }

    public double getAmount() {
        return this.amount;
    }

    @Override
    public String toString(){
        double balanceToDouble = (double) (balance / 100.00);
        SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss:SS");
        String formatedDate = formater.format(this.date);
        return formatedDate + "  |  " + this.amount + "   |  " + balanceToDouble;
    }
}
