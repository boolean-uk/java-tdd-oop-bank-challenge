package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Bank {
    private static Bank instance;
    private List<BankAccount> accounts;
    private Bank() {
        accounts = new ArrayList<>();
    }

    public static Bank getInstance() {
        if (instance == null) {
            synchronized (Bank.class) {
                if (instance == null) {
                    instance = new Bank();
                }
            }
        }
        return instance;
    }

    public void addAccount(BankAccount account) throws IllegalArgumentException {
        if (getAccountNumbers().contains(account.getAccountNumber())) {
            throw new IllegalArgumentException("Account number already exists");
        }
        accounts.add(account);
    }

    public String generateAccountNumber() {
        StringBuilder accountNumber = new StringBuilder();
        do {
            accountNumber.setLength(0);
            Random random = new Random();
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    accountNumber.append(random.nextInt(10));
                }
                accountNumber.append(" ");
            }
            accountNumber.deleteCharAt(accountNumber.length() - 1);
        } while (getAccountNumbers().contains(accountNumber.toString()));
        return accountNumber.toString();
    }

    public List<BankAccount> getAccounts() {
        return accounts;
    }

    public List<String> getAccountNumbers() {
        return accounts.stream()
                .map(BankAccount::getAccountNumber)
                .toList();
    }

    public void reset() {
        accounts.clear();
    }

}
