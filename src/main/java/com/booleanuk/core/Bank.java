package com.booleanuk.core;

import java.util.HashMap;

public class Bank {
    private HashMap<String, Account> accounts;
    private int accountIterator = 968736856;

    public Bank() {
        this.accounts = new HashMap<>();
    }

    public String addAccount(String firstName, String lastName, String type, String branch, double amount) {
        this.accountIterator++;
        String accountNr = Integer.toString(accountIterator);


        return accountNr;
    }

    public Account getAccount(String accountNr) {
        if (accounts.containsKey(accountNr))
            return accounts.get(accountNr);
        return null;
    }

    public double getBalance(String accountNr) {
        return 2.2;
    }

    public boolean deposit(String accountNr, double amount) {
        return true;
    }

    public double withdraw(String accountNr, double amount) {
        return amount;
    }

}
