package com.booleanuk.core;

import java.util.ArrayList;

public class Account {
    private ArrayList<Info> info;
    private int id;
    private String type;
    private int balance;

    private int customerId;

    public Account(int accountId, String accountType, int initDeposit) {
        this.id = accountId;
        this.type = accountType;
        this.balance = initDeposit;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public int getBalance() {
        return balance;
    }
}
