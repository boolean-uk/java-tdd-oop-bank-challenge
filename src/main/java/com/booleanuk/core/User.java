package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private List<Account> accounts;

    public User(String name) {
        this.name = name;
        accounts = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Account> getAccounts() {
        return accounts;
    }
}
