package com.booleanuk.core;

import java.util.Random;

public class User {
    private String name;
    private String email;
    private int id;

    private CurrentAccount current;
    private SavingsAccount savings;

    Random random;

    public User(String name, String email){
        this.random = new Random();
        this.id = setId();
        this.name = setName(name);
        this.email = setEmail(email);
        this.current = null;
        this.savings = null;
    }

    public CurrentAccount createCurrentAccount(){
        return this.current = new CurrentAccount(this);
    }
    public SavingsAccount createSavingsAccount(){
        return this.savings = new SavingsAccount(this);
    }

    public int setId(){
        return this.id = random.nextInt(100000,1000000);
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

