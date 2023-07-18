package com.booleanuk.core;

import java.util.*;

public class Customer {

    private String name;
    private String phone;
    private String address;
    private HashMap<String,Account> accounts;

    public Customer(String name, String phone, String address) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.accounts = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public HashMap<String,Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(HashMap<String, Account> accounts) {
        this.accounts = accounts;
    }

    public SavingsAccount createSavingsAccount(String savingsAccountNumber) {
        SavingsAccount savingsAccount = new SavingsAccount(savingsAccountNumber);
        this.accounts.put(savingsAccountNumber,savingsAccount);
        return savingsAccount;
    }
    public CurrentAccount createCurrentAccount(String currentAccountNumber) {
        CurrentAccount currentAccount = new CurrentAccount(currentAccountNumber);

        this.accounts.put(currentAccountNumber,currentAccount);
        return currentAccount;
    }
}
