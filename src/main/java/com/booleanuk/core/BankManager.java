package com.booleanuk.core;

import java.util.HashMap;

public class BankManager {
    private final HashMap<String, Account> accounts = new HashMap<>();

    // Creates a new account based on the provided type.
    // Generates an account number which is based on number of accounts
    // in the system.
    public Account createAccount(AccountType accountType, BankBranch branch) {
        String accountNumber = generateAccountNumber(accountType);
        Account account;

        if (accountType == AccountType.CURRENT) {
            account = new CurrentAccount(branch);
            accounts.put(accountNumber, account);
        } else if (accountType == AccountType.SAVINGS) {
            account = new SavingsAccount(branch);
            accounts.put(accountNumber, account);
        } else {
            return null;
        }
        return account;
    }

    // Returns an account by its number, mainly for testing purposes
    // but could easily be used in business logic
    public Account getAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }

    // Account number generator
    private String generateAccountNumber(AccountType accountType) {
        String prefix = accountType.name().substring(0, 3);
        int number = accounts.size();
        return prefix + number; // Example output: SAV3 || CUR523
    }
}
