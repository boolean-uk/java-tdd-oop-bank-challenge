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
            return true;
        } else {
            return false;
        }
    }


    public boolean withdraw(double amount) {
        if (amount <= balance) {
            return true;
        } else {
            return false;
        }
    }



}
