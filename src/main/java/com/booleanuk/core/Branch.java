package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class Branch {
    private String branchName;
    private List<Account> accounts;

    public Branch(String branchName) {
        this.branchName = branchName;
        this.accounts = new ArrayList<>();
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void listAccounts() {
        System.out.println("Accounts for branch: " + branchName);
        for (Account account : accounts) {
            System.out.println("Account ID: " + account.getAccountID() + ", Balance: " + account.getBalance());
        }
    }


    @Override
    public String toString() {
        return branchName;
    }


}
