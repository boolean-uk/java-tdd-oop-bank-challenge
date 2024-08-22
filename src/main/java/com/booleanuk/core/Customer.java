package com.booleanuk.core;
import java.util.ArrayList;
import java.util.List;

public class Customer {
    String name;
    List<Account> accounts;

    public  Customer(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    public boolean requestCurrentAccount() {
        return true;
    }

    public List<Account> getAccounts() {
        return accounts;
    }
}
