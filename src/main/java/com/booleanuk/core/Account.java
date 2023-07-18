package com.booleanuk.core;

import java.util.ArrayList;

public class Account {
    String accountOwner;
    ArrayList<Transaction> transactionHistory;

    String branchCode;

    public Account(String accountOwner, String branchCode) {
        this.accountOwner = accountOwner;
        this.transactionHistory = new ArrayList<>();
        this.branchCode = branchCode;
    }

    public boolean depositMoney(double amountDeposited){
        if(amountDeposited<0)
            return false;
        transactionHistory.add(new Transaction(amountDeposited, "deposit"));
        return true;
    }

    public boolean withdrawMoney(double amountWithdrawn){
        if(amountWithdrawn > calculateBalance())
            return false;

        transactionHistory.add(new Transaction(amountWithdrawn, "withdrawal"));
        return true;
    }

    public double calculateBalance(){
        double balance = 0;
        for (Transaction transaction : transactionHistory){
            balance += transaction.getType().equals("deposit") ? transaction.getAmount() : -transaction.getAmount();
        }
        return balance;
    }

    public String generateBankStatement(){
        BankStatementGenerator bankStatementGenerator = new BankStatementGenerator();
        return bankStatementGenerator.generateBankStatement(this);
    }
    public String getAccountOwner() {
        return accountOwner;
    }

    public ArrayList<Transaction> getTransactionHistory() {
        return transactionHistory;
    }

}