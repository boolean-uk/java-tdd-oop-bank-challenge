package com.booleanuk.core;

import java.util.HashMap;
import java.util.Map;

public class Customer {
    private int id;
    private String firstName;
    private String lastName;
    private Map<Integer, Account> accounts;
    private int nextAccountNumber;

    public Customer(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.accounts = new HashMap<>();
        this.nextAccountNumber = 1; // Start account numbering from 1
    }

    public void addAccount(Account account) {
        accounts.put(nextAccountNumber++, account);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Map<Integer, Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Map<Integer, Account> accounts) {
        this.accounts = accounts;
    }

    public int getNextAccountNumber() {
        return nextAccountNumber;
    }

    public void setNextAccountNumber(int nextAccountNumber) {
        this.nextAccountNumber = nextAccountNumber;
    }
    public Account getAccount(int accountNumber) {
        return accounts.get(accountNumber);
    }

}
