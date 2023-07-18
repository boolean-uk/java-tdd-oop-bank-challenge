package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class Branch {
    private String branchName;
    private String branchLocation;
    private List<BankAccount> accounts;
    private Bank bank;

    public Branch(String branchName, String branchLocation, Bank bank) {
        this.branchName = branchName;
        this.branchLocation = branchLocation;
        this.accounts = new ArrayList<>();
        this.bank = bank;
        bank.addBranch(this);
    }

    public String getBranchName() {
        return branchName;
    }

    public String getBranchLocation() {
        return branchLocation;
    }

    public void addAccount(BankAccount account) {
        accounts.add(account);
    }

    public void removeAccount(BankAccount account) {
        accounts.remove(account);
    }

    public List<BankAccount> getAccounts() {
        return accounts;
    }

    public int branchSize() {
        return accounts.size();
    }
}