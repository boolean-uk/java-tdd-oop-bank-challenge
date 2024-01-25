package com.booleanuk.core;

import java.util.ArrayList;
import java.util.Date;

public class Account {
    int accountId;
    double balance;
    ArrayList<Transaction> transactions;
    BankStatementGenerator bankStatementGenerator;

    public Account(int accountId, BankStatementGenerator bankStatementGenerator) {
        this.accountId = accountId;
        this.balance = 0.0;
        transactions = new ArrayList<>();
        this.bankStatementGenerator = bankStatementGenerator;
    }

    public int getAccountId() {
        return this.accountId;
    }

    public double getBalance() {
        return this.balance;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public void withdraw(double amount) {

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
}
