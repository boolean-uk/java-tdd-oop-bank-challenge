package com.booleanuk.core;

import java.time.LocalDateTime;
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
        this.info = new ArrayList<>();
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
    public ArrayList<Info> getInfo() {
        return info;
    }

    public void addWithdrawInfo(int amount) {
        LocalDateTime transactionDate = LocalDateTime.now();
        int newBalance = balance - amount;
        Info withdrawInfo = new Info(transactionDate, 0, amount, newBalance, customerId, id);
        info.add(withdrawInfo);
        balance = newBalance;
    }
}
