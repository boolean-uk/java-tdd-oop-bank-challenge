package com.booleanuk.core;

import java.util.ArrayList;

public class Account {
    private int id;
    private String type;
    private int balance;
    private int customerId;
    private ArrayList<Statement> statements;

    public Account(int customerId, String type, int initalDeposit){
        this.id = id;
        this.type = type;
        this.balance = initalDeposit;
        this.customerId = customerId;
        this.statements = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public ArrayList<Statement> getStatements() {
        return statements;
    }

    public void addDepositStatement (int ammount) {  //used for account creation too
        getStatements().add(new Statement( getCustomerId(), getId(), ammount, 0));
    }

    public void addWithdrawStatement (int ammount) {
        getStatements().add(new Statement( getCustomerId(), getId(), 0, ammount));
    }

}
