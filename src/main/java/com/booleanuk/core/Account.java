package com.booleanuk.core;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Account {

    private String accountNumber;
    private double balance;

    private String accountType;

    private List<Transaction> transactionHistory;

    protected String date;

    public Account(String accountNumber, double balance, String accountType) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.accountType = accountType;
        this.transactionHistory = new ArrayList<>();
        ZonedDateTime zdt = ZonedDateTime.now();
        DateTimeFormatter createDate = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        this.date = createDate.format(zdt);

    }

    public void setBalance(double newBalance) {
        this.balance = newBalance;
    }

    public double getBalance() {
        return this.balance;
    }

    public boolean depositAmount(double deposit) {
        if (deposit >= 0.00) {
            double newBalance = this.getBalance() + deposit;
            this.setBalance(newBalance);
            Transaction transaction = new Transaction(this.date, deposit, 0.00, newBalance);
            addToTransactionHistory(transaction);
            System.out.println("checking if deposit works" + transaction);
            return true;
        } else {
            return false;
        }
    }

    public boolean withdrawAmount(double withdraw) {
        if (withdraw >= 0.00 && this.getBalance() >= withdraw) {
            double newBalance = this.getBalance() - withdraw;
            this.setBalance(newBalance);
            Transaction transaction = new Transaction(this.date, withdraw, 0.00, newBalance);
            addToTransactionHistory(transaction);
            System.out.println("checking if withdraw works" + transaction);
            return true;
        } else {
            return false;
        }
    }

    public boolean addToTransactionHistory(Transaction transaction) {
        transactionHistory.add(transaction);
        return true;
    }

    public List<Transaction> getTransactionHistory() {
        System.out.println("transaction history retrieved" + transactionHistory);
        return transactionHistory;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public String generateBankStatement() {
        StringBuilder bankStatement = new StringBuilder("date       || credit  || debit  || balance\n");
        for (Transaction transaction : transactionHistory) {
            String formattedTransaction = String.format(
            "%-11s|| %8.2f|| %7.2f|| %7.2f",
                    transaction.getDate(),
                    transaction.getCredit(),
                    transaction.getDebit(),
                    transaction.getBalance()
        );
            bankStatement.append(formattedTransaction).append("\n");
        }
        System.out.println(bankStatement);
        return bankStatement.toString();
    }
}

