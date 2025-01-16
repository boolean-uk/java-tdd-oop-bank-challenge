package com.booleanuk.core;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.UUID;


public class Transaction {
    private final String date; //needs time as well!!
    private double amount;
    enum Type {WITHDRAWAL, DEPOSIT};
    private final Type type;
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
    private Type setType() {
        if (this.amount < 0.0) {
            this.amount *= -1;
            return Type.WITHDRAWAL;
        } else {
            return Type.DEPOSIT;
        }
    }

    public double getAmount() {
        return amount;
    }

    public Type getType() {
        return this.type;
    }

    public UUID getUid() {
        return this.uid;
    }

    @Override
    public String toString() {
        if (this.type.equals(Type.WITHDRAWAL)) {
            return String.format("%21s || %10s || %8s || ", this.date, this.amount, " ");
        } else {
            return String.format("%21s || %10s || %8s || ", this.date, " ", this.amount);
        }

    }

}
