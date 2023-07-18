package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class Branch {
    private final String branchName;
    private final List<Account> accounts;
    private final List<Client> clients;

    public Branch(String branchName) {
        this.branchName = branchName;
        this.accounts = new ArrayList<>();
        this.clients = new ArrayList<>();
    }

    public String getBranchName() {
        return branchName;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void removeAccount(Account account) {
        accounts.remove(account);
    }
    public List<Client> getClients() {
        return clients;
    }

}
