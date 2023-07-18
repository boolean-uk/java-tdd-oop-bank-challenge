package com.booleanuk.extension;

import com.booleanuk.core.Account;

import java.util.ArrayList;
import java.util.List;

public class Branch {
    private String location;
    private List<Account> accounts = new ArrayList<>();

    public Branch(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public String associate(Account account) {
        if (accounts.contains(account)) {
            return "This account already associated with this branch";
        } else {
            accounts.add(account);
        }
        return "Associated to the branch located in " + this.location;
    }

    @Override
    public String toString() {
        return "Branch{" +
                "location='" + location + '\'' +
                ", accounts=" + accounts +
                '}';
    }
}
