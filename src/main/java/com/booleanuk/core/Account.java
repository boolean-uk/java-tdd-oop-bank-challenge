package com.booleanuk.core;

import java.util.ArrayList;

public class Account {
    String accountName;
    String accountID;
    ArrayList<Transaction> transactions;
    int balance;

    public Account(String accountName)
    {
        this.accountName = accountName;
        this.accountID = "" ; // Will get to that
        this.transactions = new ArrayList<>();
        this.balance = 0;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public boolean deposit(int amount)  {
        if(amount >= 0) {
            this.transactions.add(new Transaction(amount,true));
            this.balance += amount;
            return true;
        }
        System.out.println("Cannot deposit negative value!");
        return false;
    }

    public String generateID(String owner)
    {
        String[] names = owner.split(" ");
        StringBuilder ID = new StringBuilder();
        for(int i = 0; i < names[names.length-1].length(); i++)
        {
            char c = names[names.length-1].charAt(i);
            System.out.println("Char " + c + ": " + (int) c);
            ID.append((int) c);
        }
        return ID.toString();
    }

    public boolean withdraw(int amount)  {
        if(amount >= 0) {
            this.transactions.add(new Transaction(amount,false));
            this.balance -= amount;
            return true;
        }
        System.out.println("Cannot withdraw negative value!");
        return false;
    }
}
