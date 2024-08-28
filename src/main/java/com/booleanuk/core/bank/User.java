package com.booleanuk.core.bank;

import com.booleanuk.core.accounts.Account;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class User {

    // TODO: Not safe to store personal numbers ike this, should be a uniwueId instead?
    // It's personal number for now for simplicity

    private String personalNumber;
    private Map<String, Account> accounts;

    public User(String personalNumber) {
        this.personalNumber = personalNumber;
        this.accounts = new HashMap<>();
    }

    protected void addAccount(Account account) {
        this.accounts.put(account.getAccountNumber(), account);
    }

    public ArrayList<Account> getAllAccounts() {
        return new ArrayList<>(accounts.values());
    }
}
