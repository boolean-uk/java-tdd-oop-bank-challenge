package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private List<Account> accounts;
    private int id;
    public Customer(int id) {
        this.id = id;
        this.accounts = new ArrayList<>();
    }
    public int getId() {
        return id;
    }
    public List<Account> getAccounts() {
        return accounts;
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public boolean createCurrentAccount(String accountType, int initMoney) {
        if (hasAccountOfType(accountType)) {
            return false;
        }
        int accountId = getRandomAccountId();
        Account account = new Account(accountId, accountType, initMoney);
        accounts.add(account);
        return true;
    }

    public boolean createSavingsAccount(String accountType, int initMoney) {
        if (hasAccountOfType(accountType)) {
            return false;
        }
        int accountId = getRandomAccountId();
        Account account = new Account(accountId, accountType, initMoney);
        accounts.add(account);
        return true;
    }

    private boolean hasAccountOfType(String accountType) {
        for (Account account : accounts) {
            if (account.getType().equalsIgnoreCase(accountType)) {
                return true;
            }
        }
        return false;
    }
    public boolean withdraw(int amount, String accountType) {
        Account account = getAccountByType(accountType);
        if (account == null) {
            return false;
        }

        if (amount > account.getBalance()) {
            return false;
        }

        account.addWithdrawInfo(amount);
        return true;
    }

    private Account getAccountByType(String accountType) {
        for (Account account : accounts) {
            if (account.getType().equalsIgnoreCase(accountType)) {
                return account;
            }
        }
        return null;
    }

    private int getRandomAccountId() {
        return accounts.size() + 1;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Customer)) return false;
        Customer other = (Customer) obj;
        return id == other.id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }
}
