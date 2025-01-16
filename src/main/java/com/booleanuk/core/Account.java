package com.booleanuk.core;

import java.util.ArrayList;

public class Account {

    private final ArrayList<Transaction> transactions;
    private final int accountNumber;
    private StringBuilder stringBuilder = new StringBuilder();
    private int prefix;
    private double limit;
    private boolean overDraftRequested;
    private double requestedLimit;


    public Account(int prefix, int accountNumber) {
        this.accountNumber = accountNumber;
        this.transactions = new ArrayList<>();
        this.stringBuilder.insert(0, String.format("%21s || %10s || %8s || %8s\n", "Date", "Withdrawal", "Deposit", "Balance"));
        this.prefix = prefix;
        this.limit = 0.0;
        this.requestedLimit = 0.0;
        this.overDraftRequested = false;
    }

    public void makeTransaction(double amount) {
        Transaction transaction = new Transaction(amount);
        this.transactions.add(transaction);
        //It might seem a bit odd to already start generating the statement here, but the only alternative I can think of
        //is that Transaction gets to know about the balance of the account despite it just being a record class.
        //Looping over the transaction list after every transaction has been completed only gives the final balance, not the balance after each transaction
        this.stringBuilder.append(String.format(transaction + "%8s\n", getBalance()));

    }

    public StringBuilder generateStatement() {
        return this.stringBuilder;
    }

    public ArrayList<Transaction> getTransactions() {
        return this.transactions;
    }

    public double getBalance() {
        double total = 0.0;
        for (Transaction transaction: this.transactions) {
            if (transaction.getType().equals(Transaction.Type.DEPOSIT)) {
                total += transaction.getAmount();
            } else {
                if (total - transaction.getAmount() > this.limit) {
                    total -= transaction.getAmount();
                }
            }
        }
        return total;
    }

    public int getAccountNumber() {
        return this.accountNumber;
    }

    public int getPrefix() {
        return this.prefix;
    }

    public double getLimit() {
        return this.limit;
    }

    public void requestOverdraft(double amount) {
        this.overDraftRequested = true;
        this.requestedLimit = amount;
    }

    public void changeLimit() {
        this.limit -= this.requestedLimit;
        this.overDraftRequested = false;
        this.requestedLimit = 0.0;
    }

    public boolean getRequestStatus() {
        return this.overDraftRequested;
    }


}
