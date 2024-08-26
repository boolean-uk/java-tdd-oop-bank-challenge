package com.booleanuk.core;

import java.util.ArrayList;

abstract class Account {
    private String fullName;
    private String accountNumber;
    private double balance;
    private ArrayList<Transaction> transactions;
    private OverdraftRequest overdraftRequest;

    public Account(String fullName, String accountNumber) {
        this.fullName = fullName;
        this.accountNumber = accountNumber;
        this.setBalance(0.0);
        this.setTransactions(new ArrayList<>());
        this.overdraftRequest = null;
    }

    public void requestOverdraft(double limit) {
        if (this.overdraftRequest == null) {
            this.overdraftRequest = new OverdraftRequest(this, limit);
            System.out.println("Overdraft request submitted for limit: " + limit);
        }
        else {
            System.out.println("An overdraft request is already pending.");
        }
    }

    public void deposit(double amount) {
        this.balance += amount;
        this.transactions.add(new Transaction(amount, this.getBalance()));
    }

    public void withdraw(double amount) {
        if (this.balance) {
            this.balance -= amount;
            this.transactions.add(new Transaction(-amount, this.getBalance()));
            System.out.println("Successful withdraw, new balance is: " + this.getBalance());
        }
        else {
            System.out.println("Insufficient funds, even with overdraft.");
        }
    }

    public void printStatement() {
        String title = "\t ~~~~ TRANSACTION HISTORY ~~~~ ";
        String columnsTitle = String.format("%-10s || %-6s || %-6s || %-6s", "date", "credit", "debit", "balance");
        System.out.println(title + "\n".repeat(2) + columnsTitle);

        for (Transaction transaction : transactions.reversed()) {
            System.out.println(transaction);
        }
    }

    public void clearOverdraftRequest() {
        this.overdraftRequest = null;
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }

    public double getBalance() {
        double balance = 0.0;
        for (Transaction transaction : this.transactions) {
            balance += transaction.getAmount();
        }
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public OverdraftRequest getOverdraftRequest() {
        return this.overdraftRequest;
    }

    public static void main(String[] args) {

        Current currentAccount = new Current("Bobby", "22433423424");
        currentAccount.requestOverdraft(1000);

        BankManager manager = new BankManager();
        manager.receiveRequest(currentAccount.getOverdraftRequest());
        manager.processRequest();

        currentAccount.withdraw(500);

        currentAccount.printStatement();

    }
}
