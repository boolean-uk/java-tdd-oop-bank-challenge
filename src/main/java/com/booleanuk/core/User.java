package com.booleanuk.core;

import java.util.ArrayList;

public class User {
    private ArrayList<Account> accounts;
    private String userId;
    private String name;

    public User(String userId, String name) {
        this.accounts = new ArrayList<>();
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }
}
