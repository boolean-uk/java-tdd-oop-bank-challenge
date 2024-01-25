package com.booleanuk.core;

public class User {
    String name;
    String email;
    double balance;
    Account current;
    Account savings;

    public User(String name, String email){
        this.name = setName(name);
        this.email = setEmail(email);
        this.balance = 0.00;
        this.current = null;
        this.savings = null;
    }
    public String getName() {
        return name;
    }

    public String setName(String name) {
        return this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public String setEmail(String email) {
        return this.email = email;
    }

    public double getBalance() {
        return balance;
    }

    public User setBalance(double balance) {
        this.balance = balance;
        return this;
    }

    public Account getCurrentAccount() {
        return current;
    }

    public User setCurrentAccount(Account current) {
        this.current = current;
        return this;
    }

    public Account getSavingsAccount() {
        return savings;
    }

    public User setSavingsAccount(Account savings) {
        this.savings = savings;
        return this;
    }
}
