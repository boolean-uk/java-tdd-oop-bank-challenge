package com.booleanuk.core;

import java.util.HashMap;

public class BankManager {
    private final HashMap<String, Account> accounts = new HashMap<>();
    public boolean createAccount(AccountType accountType) {
        String accountNumber = generateAccountNumber(accountType);

        if (accountType == AccountType.CURRENT) {
            accounts.put(accountNumber, new CurrentAccount());
        } else if (accountType == AccountType.SAVINGS) {
            accounts.put(accountNumber, new SavingsAccount());
        } else {
            return false;
        }
        return true;
    }

    public HashMap<String, Account> getAccounts() {
        return accounts;
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
