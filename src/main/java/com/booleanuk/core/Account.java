package com.booleanuk.core;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Account {

    private String accountType;
    private String accountNumber;
    private String date;
    private double balance;
    private List<Transaction> transactionList;

    public Account(String accountNumber, double balance, String accountType)
    {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.accountType = accountType;
        this.transactionList = new ArrayList<>();
        ZonedDateTime currentTime = ZonedDateTime.now();
        DateTimeFormatter createDate = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        this.date = createDate.format(currentTime);
    }

    public String getAccountType() {
        return accountType;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean addTransactionList(Transaction transaction)
    {
        transactionList.add(transaction);
        return true;
    }

    public List<Transaction> getTransactionList()
    {
        return transactionList;
    }

    public boolean deposit(double deposit)
    {
        if (deposit > 0f)
        {
            double updatedBalance = this.getBalance() + deposit;
            this.setBalance(updatedBalance);
            Transaction transaction = new Transaction(this.date, deposit, 0f, updatedBalance);
            addTransactionList(transaction);
            System.out.println("Verifying deposit: " + transaction);
            return true;
        }
        return false;
    }

    public boolean withdraw(double withdraw)
    {
        if (withdraw > 0f && withdraw <= this.getBalance())
        {
            double updatedBalance = this.getBalance() - withdraw;
            this.setBalance(updatedBalance);
            Transaction transaction = new Transaction(this.date, withdraw, 0f, updatedBalance);
            addTransactionList(transaction);
            System.out.println("Verifying withdraw: " + transaction);
            return true;
        }
        return false;
    }

    public void bankStatement(Account account) {
        System.out.println("Account number: " + account.accountNumber);
        System.out.printf("%10s || %10s || %10s || %10s\n", "date", "credit", "debit", "balance");
        List<Transaction> transactions = account.getTransactionList();
        Collections.reverse(transactions);
        for (Transaction transaction : transactionList)
        {
            System.out.printf("%10s || %10s || %10s || %10.2f\n", transaction.getDate(), transaction.getCredit(), transaction.getDebit(), transaction.getBalance());
        }
    }

}
