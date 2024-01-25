package com.booleanuk.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Customer {


    private String name;
    private int customerID;

    private Map<String, Account> accounts;
    public Customer(String name, int customerID) {
        this.name = name;
        this.customerID = customerID;
        this.accounts = new HashMap<>();

    }
    public String getName() {
        return name;
    }
    public Map<String, Account> getAccounts() {
        return accounts;
    }

    public void addAccount(String accountType, Account account) {
        accounts.put(accountType, account);
    }

    public Account getAccount(String accountType) {
        return accounts.get(accountType);
    }


    public int getCustomerID() {
        return customerID;
    }
}