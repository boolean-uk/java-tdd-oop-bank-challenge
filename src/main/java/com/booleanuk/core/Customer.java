package com.booleanuk.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Customer {
    private List<BankAccount> accounts = new ArrayList<>();
    private List<BankStatement> statements = new ArrayList<>();

    private final int id;
    private static int nextId = 0;
    private String phoneNumber;
    private String email;
    private final String firstName;
    private final String lastName;

    public Customer(String phoneNumber, String email, String firstName, String lastName) {
        this.id = nextId++;
        this.phoneNumber = phoneNumber;
        if (!email.contains("@")) {
            throw new IllegalArgumentException("Invalid email address");
        }
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void createAccount(AccountType accountType) {} // TODO

    public void deposit(String accountNumber, double amount) throws IllegalArgumentException {} // TODO

    public void withdraw(String accountNumber, double amount) throws IllegalArgumentException {} // TODO

    public List<BankAccount> getAccounts() {
        return accounts;
    }

    public List<BankStatement> getStatements() {
        return statements;
    }

    public int getId() {
        return id;
    }

    public static int getNextId() {
        return nextId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
