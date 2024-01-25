package com.booleanuk.core;

import java.util.Random;

public class User {
    private static int lastAssignedId;
    private String name;
    private String email;
    private int id;
    private boolean overdraftAccess;
    private double overdraftAmount;

    private CurrentAccount current;
    private SavingsAccount savings;


    private Bank bank;

    public User(String name, String email, Bank bank){
        this.id = setId();
        this.name = setName(name);
        this.email = setEmail(email);
        this.current = null;
        this.savings = null;
        this.bank = bank;
        this.overdraftAccess = false;
        this.overdraftAmount = 0;
    }

    public User(String name, String email){
        this.id = setId();
        this.name = setName(name);
        this.email = setEmail(email);
        this.current = null;
        this.savings = null;
        this.bank = null;
    }

    public int setId(){
        return lastAssignedId++;
    }
    public boolean overdraftAccess(double amount){
        if(isOverdraftAccess()){
            setOverdraftAmount(amount);
            return true;
        }
        return false;
    }

    public boolean isOverdraftAccess() {
        return overdraftAccess;
    }

    public User setOverdraftAccess(boolean overdraftAccess) {
        this.overdraftAccess = overdraftAccess;
        return this;
    }

    public double getOverdraftAmount() {
        return overdraftAmount;
    }

    public User setOverdraftAmount(double overdraftAmount) {
        this.overdraftAmount = overdraftAmount;
        return this;
    }

    public void createCurrentAccount(){
        this.current = new CurrentAccount();
    }
    public void createSavingsAccount(){
        this.savings = new SavingsAccount();
    }

    public String getBankBranch(){
        return this.bank.getBranch();
    }

    public int getId(){
        return this.id;
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
    public Account getCurrentAccount() {
        return this.current;
    }
    public Account getSavingsAccount() {
        return this.savings;
    }

}

