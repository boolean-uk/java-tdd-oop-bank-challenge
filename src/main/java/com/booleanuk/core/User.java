package com.booleanuk.core;

import java.util.ArrayList;

public class User {
    private ArrayList<Account> accounts;
    private String userId;

    public User(String userId) {
        this.accounts = new ArrayList<>();
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }
}
