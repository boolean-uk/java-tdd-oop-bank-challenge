package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class Account {

    private Bank bank;
    private int id;
    private String type;
    private String branch;
    private ArrayList<Transaction> transactions;
    private int interest;

    public boolean deposit(int amount) {
        if (amount < 1) {
            System.out.println("Amount must be positive.");
            return false;
        }
        Transaction transaction = new Transaction(amount);
        this.transactions.add(transaction);
        return true;
    }

    public boolean withdraw(int amount) {
        if (amount < 1) {
            System.out.println("Amount must be positive.");
            return false;
        }
        if (this.calcCurrentAmount()-amount < 0) {
            System.out.println("Not enough money in savings account.");
            return false;
        }
        Transaction transaction = new Transaction(-amount);
        this.transactions.add(transaction);
        return true;
    }

    public int calcCurrentAmount() {
        int amount = 0;
        for (Transaction transaction : this.transactions) {
            amount += transaction.getAmount();
        }
        return amount;
    }

    public List<String> printBankStatements() {
        List<String> transactionStrings = new ArrayList<>();
        String transactionString;
        int balance = 0;
        String currAmount;
        for (Transaction transaction : this.transactions) {
            balance += transaction.getAmount();
            transactionString = "|| " + transaction.getDate().toString() + " || ";
            if (transaction.getAmount() < 0) {
                currAmount = "" + (-transaction.getAmount());
                transactionString += "         || ";
                transactionString += this.addBlankSpaces(8-currAmount.length()) + currAmount + " || ";

            } else {
                currAmount = "" + transaction.getAmount();
                transactionString += this.addBlankSpaces(8-currAmount.length()) + currAmount + " || ";
                transactionString += "         || ";
            }
            currAmount = "" + balance;
            transactionString += this.addBlankSpaces(8-currAmount.length()) + currAmount + " ||";
            transactionStrings.addFirst(transactionString);
        }
        return transactionStrings;
    }

    public String addBlankSpaces(int limit) {
        return " ".repeat(Math.max(0, limit));
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }

    public int getInterest() {
        return interest;
    }

    public void setInterest(int interest) {
        this.interest = interest;
    }
}
