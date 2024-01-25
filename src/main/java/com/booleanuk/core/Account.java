package com.booleanuk.core;

import java.util.ArrayList;
import java.util.Date;

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

    public ArrayList<BankStatement> getBankStatements() {
        return bankStatements;
    }


    public boolean clearBankStatements() {
        this.bankStatements.clear();
        return true;
    }

    public boolean deposit(double v) {
        this.addBankStatement(new DepositStatement(v, this.getBalance()+v));
        this.balance += v;
        return true;
    }

    public boolean withdraw(double v) {

        if(v < this.getBalance()) {
            this.addBankStatement(new WithdrawStatement(v, this.getBalance()-v));
            this.balance -= v;
            return true;
        }

        return false;
    }


    private void addBankStatement(BankStatement bankStatement) {
        this.bankStatements.add(bankStatement);
    }

    public String printBankStatements() {
        String returnString = "\n";
        for (BankStatement statement : bankStatements) {
            returnString += statement.getStatementAsString();
        }
        return returnString;
    }
}
