package com.booleanuk.core;

import com.booleanuk.core.extension.BankBranch;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public abstract class Account {
    protected String name;
    protected String accountNumber;
    protected double balance;
    protected List<Transaction> transactions;
    protected BankBranch bankBranch;
    protected Random random = new Random();

    public Account() {
        this.balance = 0;
        this.transactions = new ArrayList<>();
    }

    public void generateStatement() {
        System.out.printf("%-10s || %-8s || %-8s || %-8s\n", "date", "credit", "debit", "balance");
        ArrayList<Transaction> transactionsCopy = new ArrayList<>(transactions);
        Collections.reverse(transactionsCopy);
        for (Transaction transaction : transactionsCopy) {
            if (transaction.getDeposit() == 0) {
                System.out.printf("%-10s || %-8s || %.2f || %.2f\n", transaction.getLocalDateFormatted(), "", transaction.getWithdraw(), transaction.getBalance());
            } else if (transaction.getWithdraw() == 0) {
                System.out.printf("%-10s || %.2f || %-8s || %.2f\n", transaction.getLocalDateFormatted(), transaction.getDeposit(), "", transaction.getBalance());
            }
        }
    }

    public BankBranch getBankBranch() {
        return bankBranch;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                '}';
    }
}

