package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class Customer {

   private final String owner;
   private List<Account> accounts;

    public Customer(String owner) {
        this.owner = owner;
        this.accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        this.accounts.add(account);
    }

    public List<Account> getAccounts() {
        return this.accounts;
    }

    public boolean depositFounds(double amount, Account account) {
        return account.changeBalance(amount);
    }

    public boolean withdrawFounds(double amount, Account account) {
        return account.changeBalance(-amount);
    }

    public double showCurrentBalance(Account account) {
        return account.getBalance();
    }

    public void printBankStatements(Account account) {

    }




}
