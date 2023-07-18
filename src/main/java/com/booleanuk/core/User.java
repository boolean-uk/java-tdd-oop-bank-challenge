package com.booleanuk.core;

import java.util.HashMap;
import java.util.LinkedList;

public class User {
    private final HashMap<String, BankAccount> ownedAccounts;
    private final String firstName;
    private final String lastName;
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        ownedAccounts = new HashMap<String, BankAccount>();
    }
    public boolean createNewAccount(String accountType, double initialBalance, String id) {
        //normally I would create console interface, but this is for tests
        if(ownedAccounts.containsKey(id))
            return false;
        switch (accountType) {
            case "savings" -> ownedAccounts.put(id, new SavingsAccount(initialBalance));
            case "current" -> ownedAccounts.put(id, new CurrentAccount(initialBalance));
            default -> { return false; }
        }
        return true;
    }
    public BankAccount getAccountById(String id) {
        return ownedAccounts.get(id);
    }
}
