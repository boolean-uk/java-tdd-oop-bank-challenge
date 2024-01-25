package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class Account {

    private static final double maxLimit = 100000000.00;

    private final int accountNumber;
    private double balance;
    protected double minLimit;
    private List<BankStatement> statements;
    private Branches branch;

    public Account(int accountNumber, Branches branch) {
        this.accountNumber = accountNumber;
        this.balance = 0.00;
        this.statements = new ArrayList<>();
        this.branch = branch;
    }

    public boolean changeBalance(double amount, String date) {
        double newBalance = this.balance + amount;
        String type;
        if (newBalance >= maxLimit) {
            System.out.print("Can't put in that much money, overrides the maximum limit.\n");
            return false;
        }
        if (newBalance < this.minLimit) {
            System.out.print("Can't withdraw that much money from that account!\n");
            return false;
        }
        if (this.balance > newBalance) {
            type = "dedit";
        } else {
            type = "credit";
        }
        this.balance = newBalance;
        addNewBankStatement(date, Math.abs(amount), type);
        return true;
    }

    public int getAccountNumber() {
        return this.accountNumber;
    }

    public List<BankStatement> getStatements() {
        return this.statements;
    }

    public Branches getBranch() {
        return this.branch;
    }

    private void addNewBankStatement(String date, double amount, String type) {
        this.statements.add(0, new BankStatement(date, type, amount, this.balance));
    }
}
