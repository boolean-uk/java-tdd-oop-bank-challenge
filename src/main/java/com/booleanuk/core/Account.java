package com.booleanuk.core;

import java.time.LocalDate;

public class Account {
    Customer customer;
    double balance;
    BankStatement bankStatement = new BankStatement();
    Transaction transaction;
    Branch branch;
    public Account(Customer customer, Branch branch) {
        this.customer = customer;
        this.balance = 0.0;
        this.branch = branch;
    }
    public String deposit(double amount) {
        LocalDate date = LocalDate.now();
        transaction = new Transaction(date,0, amount, balance);
        bankStatement.add(transaction);
        balance = balance + amount;
        return "New Balance: " + balance;
    }
    public String withdraw(double amount) {
        if (amount <= balance) {
            LocalDate date = LocalDate.now();
            transaction = new Transaction(date,amount, 0, balance);
            bankStatement.add(transaction);
            balance = balance - amount;
            return "New Balance: " + balance;
        }
        return "Your balance is low";
    }
    public void printBankStatement() {
        bankStatement.printBankStatement();
    }
}
