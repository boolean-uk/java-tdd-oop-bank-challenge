package com.booleanuk.core;

import java.util.ArrayList;
import java.util.Date;

public class Account {
    private int accountId;
    private double balance;
    private ArrayList<Transaction> transactions;
    private BankStatementGenerator bankStatementGenerator;
    private Branch branch;

    public Account(int accountId, BankStatementGenerator bankStatementGenerator, Branch branch) {
        this.accountId = accountId;
        this.balance = 0.0;
        transactions = new ArrayList<>();
        this.bankStatementGenerator = bankStatementGenerator;
        this.branch = branch;
    }

    public int getAccountId() {
        return this.accountId;
    }

    public double getBalance() {
        return this.balance;
    }

    public void deposit(double amount) {
        this.balance += amount;
        generateNewTransaction("Credit", amount);
    }

    public void withdraw(double amount) {
        this.balance -= amount;
        generateNewTransaction("Debit", amount);
    }

    public String getBankStatement() {
        String bankStatement = bankStatementGenerator.generateBankStatement(this.transactions);
        return bankStatement;
    }

    private void generateNewTransaction(String transactionType, double amount) {
        Date date = new Date(); //Needs to be injected when testing
        String dateString = date.toString();
        Transaction transaction = new Transaction(transactionType, dateString, amount, this.balance);
        transactions.add(transaction);
    }

    public double getBalanceFromTransactions() {
        double balance = 0.0;

        for(Transaction transaction : transactions) {
            if(transaction.getTransactionType().equalsIgnoreCase("Credit")) {
                balance += Double.parseDouble(transaction.getAmount());
            }
            else {
                balance -= Double.parseDouble(transaction.getAmount());
            }
        }
        return balance;
    }

    public Branch getBranch() {
        return this.branch;
    }
}
