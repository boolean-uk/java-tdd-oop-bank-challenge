package com.booleanuk.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


import java.util.HashMap;
import java.util.Map;

public class Bank {
    private final Map<String, Account> accounts;

    public Bank() {
        this.accounts = new HashMap<>();
    }

    public void createAccount(String accountNumber, Account account) {
        accounts.put(accountNumber, account);
    }

    public Account getAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }

    public void printStatement(String accountNumber) {
        Account account = getAccount(accountNumber);
        if (account != null) {
            System.out.println("date       || credit  || debit  || balance");
            for (Transaction transaction : account.getTransactions()) {
                System.out.println(transaction);
            }
        } else {
            System.out.println("Account not found");
        }
    }
}

