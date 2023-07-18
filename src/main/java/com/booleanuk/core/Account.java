package com.booleanuk.core;

import java.util.ArrayList;

public class Account {
    String accountOwner;
    ArrayList<Transaction> transactionHistory;

    public Account(String accountOwner) {
        this.accountOwner = accountOwner;
        this.transactionHistory = new ArrayList<>();
    }

    public void depositMoney(double amountDeposited){

    }

    public boolean withdrawMoney(double amountWithdrawn){
        return false;
    }

    public double calculateBalance(){
        return 0;
    }

    public String getAccountOwner() {
        return accountOwner;
    }

    public ArrayList<Transaction> getTransactionHistory() {
        return transactionHistory;
    }
}
