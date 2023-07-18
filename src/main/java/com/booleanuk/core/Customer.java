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
