package com.booleanuk.core;

import java.util.ArrayList;

public class User {
    private ArrayList<Account> accounts;
    private String userId;
    private String name;

    public User(String userId, String name) {
        this.accounts = new ArrayList<>();
        this.userId = userId;
        this.name = name;
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public ArrayList<String> getAccountNumbers() {
        ArrayList<String> nums = new ArrayList<>();
        for (Account a: accounts) {
            nums.add(a.getAccountId());
        }
        return nums;
    }

    public Account getAccount(String accountId) {
        return accounts.stream().filter(account -> account.accountId.equals(accountId)).findFirst().orElse(null);
    }
}
