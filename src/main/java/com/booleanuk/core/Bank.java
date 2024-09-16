package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    public List<Account> accounts;

    public Bank() {
        this.accounts = new ArrayList<>();
    }

    public boolean createAccount(String accountNumber, double balance, String accountType) {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                System.out.println("Account with this number already exists");
                return false;
            }
        }

        if (accountType.equalsIgnoreCase("SavingsAccount")) {
            SavingsAccount savingsAccount = new SavingsAccount(accountNumber, balance, "SavingsAccount");
            accounts.add(savingsAccount);
            return true;
        } else if (accountType.equalsIgnoreCase("CurrentAccount")) {
            CurrentAccount currentAccount = new CurrentAccount(accountNumber, balance, "CurrentAccount");
            accounts.add(currentAccount);
            return true;
        } else {
            return false;
        }
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


