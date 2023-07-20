package com.booleanuk.core;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class BankStatement {
    private String statementId;
    private String accountNumber;
    private List<Transaction> transactions;

    public BankStatement(String statementId, String accountNumber) {
        this.statementId = statementId;
        this.accountNumber = accountNumber;
        this.transactions = new ArrayList<>();
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public void generateStatement(SimpleDateFormat sdf) {
        double balance = 0.0;
        System.out.println("date       || credit  || debit  || balance");
        for (Transaction transaction : transactions) {
            double amount = transaction.getAmount();
            if (amount >= 0) {
                System.out.println(sdf.format(transaction.getDate()) + " || " + amount + " ||         || " + balance);
            } else {
                System.out.println(sdf.format(transaction.getDate()) + " ||         || " + Math.abs(amount) + " || " + balance);
            }
            balance += amount;
        }
    }
}