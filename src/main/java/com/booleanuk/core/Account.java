package com.booleanuk.core;

import java.util.HashMap;

public abstract class Account {
    private String accountId;
    private int balance;
    private String branchId;
    private HashMap<String,Statement> statements;
    AccountsList accountsList = new AccountsList();

    public Account(String branchId) {
        this.branchId = branchId;
        statements = new HashMap<>();
        this.accountId = accountsList.generateAccountId(this.branchId);
    }

    public String getAccountId() {
        return this.accountId;
    }

    @Override
    public String toString() {
        return "Account " + accountId + "\nBalance: " + balance;
    }
}
