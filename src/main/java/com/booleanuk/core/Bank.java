package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    public List<Account> accounts;

    public Bank() {
        this.accounts = new ArrayList<>();
    }

    public boolean createAccount(String accountNumber, double balance, String accountType) {
        if (accountExists(accountNumber)) {
            System.out.println("Account already exists");
            return false;
        }

        Account newAccount = null;
        if (accountType.equalsIgnoreCase("SavingsAccount")) {
            newAccount = new SavingsAccount(accountNumber, balance, "SavingsAccount");
        } else if (accountType.equalsIgnoreCase("CheckingsAccount")) {
            newAccount = new CheckingsAccount(accountNumber, balance, "CheckingsAccount");
        }

        if (newAccount != null) {
            accounts.add(newAccount);
            return true;
        } else {
            return false;
        }
    }

    private boolean accountExists(String accountNumber) {
        return accounts.stream().anyMatch(account -> account.getAccountNumber().equals(accountNumber));
    }

    public String getAccountType(String accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account.getAccountType();
            }
        }
        return null;
    }
}