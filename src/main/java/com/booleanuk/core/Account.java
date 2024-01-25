package com.booleanuk.core;

import java.util.ArrayList;

public abstract class Account {
    int accountNumber;
    User owner;
    private int balance;
    ArrayList<Transaction> transactions;

    public Account(User owner) {
        setOwner(owner);
        setBalance(0);
        setAccountNumber(0);
        this.transactions = new ArrayList<>();
    }

    public boolean deposit(double credit) {
        if(credit > 0) {
            setBalance(toInt(credit));
            this.transactions.add(new Transaction(toInt(credit),toInt(this.getBalance())));
            return true;
        }
        return false;
    }

    public boolean withdraw(double debit) {
        boolean newBalanceNotLessThanZero = (this.getBalance() - debit) >= 0;
        if(debit > 0 && newBalanceNotLessThanZero) {
            this.setBalance(-toInt(debit));
            this.transactions.add(new Transaction(-toInt(debit),toInt(this.getBalance())));
            return true;
        }
        return false;
    }

    public String getBankStatement() {
        StringBuilder bankStatement = new StringBuilder();
        bankStatement.append("Date\t\t\t\t|| Credit\t|| Balance\n");
        for (Transaction transaction: this.transactions) {
            String transactionRow = transaction.getDateTimeString() + "\t|| " + this.toDouble(transaction.getAmount()) + "\t|| " + this.toDouble(transaction.getBalance()) + "\n";
            bankStatement.append(transactionRow);
        }
        return bankStatement.toString();
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public double getBalance() {
        return toDouble(balance);
    }

    public void setBalance(int balance) {
        this.balance += balance;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    private int toInt(Double amount) {
        return (int) Math.round(amount * 100);
    }

    private double toDouble(int amount) {
        return amount / 100.0;
    }

}
