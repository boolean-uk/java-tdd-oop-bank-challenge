package com.booleanuk.core;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Statement {
    Date date;
    double amount;
    int balance;

    public Statement (double amount, int balance) {
        this.date = new Date();
        this.amount = amount;
        this.balance = balance;
    }

    public Date getDate() {
        return this.date;
    }

    @Override
    public String toString(){
        double balanceToDouble = (double) (balance / 100.00);
        SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String formatedDate = formater.format(this.date);
        return formatedDate + "  |  " + this.amount + "   |  " + balanceToDouble;
    }
}
