package com.booleanuk.core;

import java.util.ArrayList;

public class Account {


    private ArrayList<BankStatement> bankStatements;

    private String accountName;



    public Account(String accountName) {
        this.accountName = accountName;
        this.bankStatements = new ArrayList<>();
    }

    public double getBalance() {
        double balance = 0.0;
        if(!bankStatements.isEmpty()) {
            for(BankStatement bankStatement : bankStatements) {
                if(bankStatement instanceof DepositStatement) {
                    balance += bankStatement.getAmount();
                }
                if(bankStatement instanceof WithdrawStatement) {
                    balance -= bankStatement.getAmount();
                }
            }
        }

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
        return true;
    }

    public boolean withdraw(double v) {

        if(v < this.getBalance()) {
            this.addBankStatement(new WithdrawStatement(v, this.getBalance()-v));
            return true;
        }

        return false;
    }


    private void addBankStatement(BankStatement bankStatement) {
        this.bankStatements.add(bankStatement);
    }

    public String printBankStatements() {
        String returnString = "\n";
        returnString += String.format("%8s %12s %12s %12s", "Date", "Debit", "Credit", "Balance\n");
        for (BankStatement statement : bankStatements) {
            returnString += statement.getStatementAsString();
        }
        return returnString;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
}
