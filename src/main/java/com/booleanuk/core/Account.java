package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class Account {

    private final String accountName;
    private final int clearingNumber;
    private final int accountNumber;
    private double balance;
    private List<BankStatement> statements;

    public Account(String accountName, int clearingNumber, int accountNumber, double startingBalance) {
        this.accountName = accountName;
        this.clearingNumber = clearingNumber;
        this.accountNumber = accountNumber;
        this.balance = startingBalance;
        this.statements = new ArrayList<>();
    }

    public boolean changeBalance(double amount) {
        balance += amount;
        return true;
    }

    public String getAccountName() {
        return this.accountName;
    }

    public int getClearingNumber() {
        return this.clearingNumber;
    }

    public int getAccountNumber() {
        return this.accountNumber;
    }

    public double getBalance() {
        return this.balance;
    }

    public List<BankStatement> getStatements() {
        return this.statements;
    }
}
