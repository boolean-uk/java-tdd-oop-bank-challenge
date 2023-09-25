package com.booleanuk.core;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BankAccount {
    public double balance;
    public String bankType;

    public BankAccount() {
    }

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public boolean deposit(double amount) {
        if (amount >= 0) {
            balance += amount;
            return true;
        } else {
            return false;
        }
    }


    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }

    public String getDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        System.out.println("This is what the date looks like from getDate(): " + formatter.format(date));
        return formatter.format(date);

    }


}
