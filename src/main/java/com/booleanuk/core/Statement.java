package com.booleanuk.core;

import java.util.Date;
import java.util.Objects;

public class Statement {
    private Date date;
    private double amount;
    private double balance;

    public Statement(Date date, double amount, double balance) {
        this.date = date;
        this.amount = amount;
        this.balance = balance;
    }

    public Date getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Statement)) {
            return false;
        }

        Statement other = (Statement) obj;
        return this.date.equals(other.date) && this.amount == other.amount && this.balance == other.balance;
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, amount, balance);
    }

    @Override
    public String toString() {
        return date + " " + amount + " " + balance;
    }
}
