package com.booleanuk.core;

import java.util.ArrayList;
import java.util.Collections;

public abstract class Account {

    private float balance;
    private ArrayList<Transaction> transactions = new ArrayList<>();
    private long accountNumber;

    public void setAccountNumber(int branchID, int accountID){
        String s = String.valueOf(branchID) + String.valueOf(accountID);
        this.accountNumber = Long.parseLong(s);
    }

    public long getAccountNumber(){
        return accountNumber;
    }

    public float getBalance(){
        return balance;
    }

    public float calculateBalance(){
        balance = 0.00f;
        for (Transaction t : transactions){
            if (t.getIsWithdrawal()){
                balance -= t.getAmount();
            }else {
                balance += t.getAmount();
            }
        }
        return  balance;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public void withdraw(float amount){
        if (calculateBalance() < amount){
            System.out.println("Not enough funds in account!");
            return;
        }
        balance -= amount;
        Transaction transaction = new Transaction(true, balance, amount);
        transactions.add(transaction);
    }

    public void deposit(float amount){
        balance += amount;
        Transaction transaction = new Transaction(false, balance, amount);
        transactions.add(transaction);

    }

    public String generateStatement(){
        ArrayList<Transaction> reversed = new ArrayList<>(transactions);
        Collections.reverse(reversed);
        StringBuilder statement = new StringBuilder();
        statement = new StringBuilder(String.format("%-20s|| %-10s|| %-10s|| %-10s\n", "date", "credit", "debit", "balance"));
        for (Transaction t : reversed){
            statement.append(t.toString()).append("\n");
        }
        return statement.toString();
    }

}
