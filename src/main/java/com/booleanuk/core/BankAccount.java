package com.booleanuk.core;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class BankAccount {
    private String accountType;
    private double balance;
    private List<Transaction> transactions;

public BankAccount(String accountType) {
    this.accountType = accountType;
    this.balance = 0;
    this.transactions = new ArrayList<>();
}


    public void deposit(double amount, String date) {}


    public void withdraw(double amount, String date) {}


    public String generateStatement() {
    return accountType;
    }
}
