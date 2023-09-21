package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class Account {

    private int accountNumber;
    private double balance;

    private List<Transaction> transactionHistory;

    public Account(int accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.transactionHistory = new ArrayList<>();
    }

    public void setBalance(double newBalance) {
        this.balance = newBalance;
    }

    public double getBalance() {
        return this.balance;
    }

    public boolean depositAmount(double deposit) {
        if (deposit >= 0.00) {
            double newBalance = this.getBalance() + deposit;
            this.setBalance(newBalance);
            return true;
        } else {
            return false;
        }
    }

    public boolean withdrawAmount(double withdraw) {
        if (withdraw >= 0.00) {
            double newBalance = this.getBalance() - withdraw;
            this.setBalance(newBalance);
            return true;
        } else {
            return false;
        }
    }
}
