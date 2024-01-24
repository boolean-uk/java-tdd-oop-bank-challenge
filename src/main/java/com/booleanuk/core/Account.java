package com.booleanuk.core;

import java.util.ArrayList;

public class Account {

    private double balance;
    private ArrayList<BankStatement> bankStatements;


    public Account() {
        this.balance = 0.00;
        this.bankStatements = new ArrayList<>();
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public ArrayList<BankStatement> getBankStatements() {
        return bankStatements;
    }

    public void setBankStatements(ArrayList<BankStatement> bankStatements) {
        this.bankStatements = bankStatements;
    }

    public boolean addBankStatement(DepositStatement depositStatement) {
        this.bankStatements.add(depositStatement);
        return true;
    }

    public boolean clearBankStatements() {
        this.bankStatements.clear();
        return true;
    }

    public boolean deposit(double v) {
        this.balance += v;
        return true;
    }

    public boolean withdraw(double v) {
        this.balance -= v;
        return true;
    }
}
