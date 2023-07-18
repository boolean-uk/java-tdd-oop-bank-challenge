package com.booleanuk.core;

import java.util.HashMap;

public class BankManager {
    private final HashMap<String, Account> accounts = new HashMap<>();
    public Account createAccount(AccountType accountType) {
        String accountNumber = generateAccountNumber(accountType);
        Account account;

        if (accountType == AccountType.CURRENT) {
            account = new CurrentAccount();
            accounts.put(accountNumber, account);
        } else if (accountType == AccountType.SAVINGS) {
            account = new SavingsAccount();
            accounts.put(accountNumber, account);
        } else {
            return null;
        }
        return account;
    }

    public Account getAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }

    private String generateAccountNumber(AccountType accountType) {
        // Generating a prefix of first three letters of account type
        String prefix = accountType.name().substring(0, 3);
        // Getting number of accounts
        int number = accounts.size();
        // Joining them together
        return prefix + number; // Example output: SAV3 || CUR523
    }
}
