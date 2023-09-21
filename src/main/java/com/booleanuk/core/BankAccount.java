package com.booleanuk.core;

import java.util.ArrayList;

public abstract class BankAccount {
    protected final ArrayList<Transaction> transactions;

    public BankAccount(){
        transactions = new ArrayList<>();
    }

    public void deposit(double amount){
        this.transactions.add(new Transaction(amount, true));
    }

    public void withdraw(double amount){
        this.transactions.add(new Transaction(amount, false));
    }

    public String generateStatements() {
        StringBuilder result = new StringBuilder();
        result.append("date       || credit  || debit   || balance\n");
        for (Transaction transaction: this.transactions){
            result.append(transaction.printData()).append("\n");
        }
        return String.valueOf(result).substring(0,result.length()-1);
    }
}
