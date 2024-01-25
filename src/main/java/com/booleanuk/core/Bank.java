package com.booleanuk.core;

import java.util.HashMap;

public class Bank {
    private HashMap<String, Account> accounts;
    private int accountIterator = 968736856;

    public Bank() {
        this.accounts = new HashMap<>();
    }

    public String addAccount(String firstName, String lastName, String type, String branch, double amount) {
        String accountNr;
        while(true) {
            this.accountIterator++;
            accountNr = Integer.toString(accountIterator);
            if (!accounts.containsKey(accountNr))
                break;
        }
        if (type.equals("Current Account"))
            accounts.put(accountNr, new CurrentAccount(accountNr, firstName, lastName, branch, amount));
        else if (type.equals("Savings Account"))
            accounts.put(accountNr, new SavingsAccount(accountNr, firstName, lastName, branch, amount));
        else
            return null;

        return accounts.get(accountNr).getAccountNr();
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
