package com.booleanuk.core;

import java.rmi.server.UID;

public class Customer extends Person{
    public Customer(String name, int UID) {
        super(name, UID);
    }

    public boolean createCurrentAccount() {
        return false;
    }

    public boolean createSavingsAccount() {
        return false;
    }

    public void generateBankStatement() {
        System.out.println("");
    }

    public boolean deposit() {
        return false;
    }

    public boolean withdraw() {
        return false;
    }
}
