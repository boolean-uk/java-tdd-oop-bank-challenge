package com.booleanuk.core;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.UUID;


public class Transaction {
    private final String date; //needs time as well!!
    private double amount;
    private final String type;
    private final UUID uid;

    public Transaction(double amount){
        this.date = new SimpleDateFormat("yyyy.MM.dd HH:mm z").format(Calendar.getInstance().getTime());
        this.amount = amount;
        this.type = this.setType();
        this.uid = UUID.randomUUID();
    }

    public String getDate() {
        return date;
    }

    //Don't want other classes to be able to set the type so this is done internally
    //This means that even if a negative transaction amount is passed in, the behaviour is still expected.
    private String setType() {
        if (this.amount < 0.0) {
            this.amount *= -1;
            return "withdrawal";
        } else {
            return "deposit";
        }
    }

    public double getAmount() {
        return amount;
    }

    public String getType() {
        return type;
    }

    public UUID getUid() {
        return this.uid;
    }

    @Override
    public String toString() {
        if (this.type.equals("withdrawal")) {
            return String.format("%21s || %10s || %8s || ", this.date, this.amount, " ");
        } else {
            return String.format("%21s || %10s || %8s || ", this.date, " ", this.amount);
        }

    }

}
