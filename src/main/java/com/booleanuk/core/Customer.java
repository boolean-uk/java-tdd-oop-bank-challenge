package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private List<Account> accounts;
    private Bank bank;

    public Customer(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    public boolean requestCurrentAccount() {
        if (bank == null) {
            System.out.println("Customer do not have a bank.");
            return false;
        }
        return bank.createCurrentAccount(this);
    }

    public boolean requestSavingsAccount() {
        if (bank == null) {
            System.out.println("Customer do not have a bank.");
            return false;
        }
        return bank.createSavingsAccount(this);
    }

    public boolean deposit(Account account, double amount){
        if (!accounts.contains(account)){
            return false;
        }
        account.setBalance(account.getBalance() + amount);
        Transaction transaction = new Transaction(amount, account.getBalance());
        account.addTransaction(transaction);
        return true;
    }

    public boolean withdraw(Account account, double amount){
        if (!accounts.contains(account)){
            return false;
        }
        if (account.getBalance() < amount){
            return false;
        }
        account.setBalance(account.getBalance() - amount);
        Transaction transaction = new Transaction(-amount, account.getBalance());
        account.addTransaction(transaction);
        return true;
    }

    public boolean generateBankStatement(Account account){
        return true;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }
}
