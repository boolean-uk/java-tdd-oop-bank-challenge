package com.booleanuk.core;

import java.util.Random;

public class User {
    String name;
    String email;
    int id;

    Account current;
    Account savings;

    Random random;

    public User(String name, String email){
        this.random = new Random();
        this.id = setId();
        this.name = setName(name);
        this.email = setEmail(email);
        this.current = null;
        this.savings = null;
    }
    public int setId(){
        return this.id = random.nextInt(100000,1000000);
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
        return current;
    }

    public Account getSavingsAccount() {
        return savings;
    }
}
