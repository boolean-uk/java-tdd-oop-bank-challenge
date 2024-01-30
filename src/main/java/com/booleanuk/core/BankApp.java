package com.booleanuk.core;
import java.util.ArrayList;
import java.util.List;

public class BankApp {
    static class Account {
        private String accountId;
        private double balance;
        private List<Transaction> transactionHistory;

        public Account(String accountId) {
            this.accountId = accountId;
            this.balance = 0;
            this.transactionHistory = new ArrayList<>();
        }

        public double calculateBalance() {
            return balance;
        }

        public void deposit(double amount) {
            balance += amount;
            transactionHistory.add(new Transaction("Deposit", amount));
        }

        public void withdraw(double amount) {
            if (balance >= amount) {
                balance -= amount;
                transactionHistory.add(new Transaction("Withdrawal", -amount));
            } else {
                System.out.println("Insufficient funds");
            }
        }

        public void sendStatement() {
        }
    }

    static class SavingsAccount extends Account {
        private String customerId;
        private String branchName;
        public SavingsAccount(String accountId) {
            super(accountId);
        }

        public void createSavingsAccount(String customerId, String branchName) {
            this.customerId = customerId;
            this.branchName = branchName;
        }

        public String getCustomerId() {
            return customerId;
        }

        public String getBranchName() {
            return branchName;
        }
    }

    static class CurrentAccount extends Account {
        private String customerId;
        private String branchName;

        public CurrentAccount(String accountId) {
            super(accountId);
        }

        public void createCurrentAccount(String customerId, String branchName) {
            this.customerId = customerId;
            this.branchName= branchName;
        }

        public String getCustomerId() {
            return customerId;
        }

        public String getBranchName() {
            return branchName;
        }

        public void requestOverdraft() {

        }
    }

    static class Branch {
        public String branchName;
        private List<Account> accounts;

        public Branch(String branchName) {
            this.branchName = branchName;
            this.accounts = new ArrayList<>();
        }

        public void addAccount(Account account) {
            accounts.add(account);
        }

        public void assessOverdraftRequest(CurrentAccount currentAccount) {

        }
    }

    static class Customer {
        public String customerId;
        public String phoneNumber;

        public Customer(String customerId, String phoneNumber) {
            this.customerId = customerId;
            this.phoneNumber = phoneNumber;
        }

        public static Customer createCustomer(String customerId, String phoneNumber) {
            return new Customer(customerId, phoneNumber);
        }
    }

    static class Transaction {
        private String type;
        private double amount;

        public Transaction(String type, double amount) {
            this.type = type;
            this.amount = amount;
        }
    }

}
