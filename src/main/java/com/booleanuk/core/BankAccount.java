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
        int balance = 0;
        StringBuilder result = new StringBuilder();
        result.append("date       || credit  || debit   || balance\n");
        for (Transaction transaction: this.transactions){
            result.append(transaction.printData());
            if (transaction.isDeposit()){
                balance += (int)(transaction.getAmount()*100);
            } else {
                balance -= (int)(transaction.getAmount()*100);
            }
            result.append(String.format("%.2f",(double) (balance/100))).append("\n");
        }
        return String.valueOf(result).substring(0,result.length()-1);
    }

    public double getBalance() {
        int balance = 0;
        for (Transaction transaction: this.transactions){
            if (transaction.isDeposit()){
                balance += (int)(transaction.getAmount()*100);
            } else {
                balance -= (int)(transaction.getAmount()*100);
            }
        }
        return (double) balance/100;
    }
}
