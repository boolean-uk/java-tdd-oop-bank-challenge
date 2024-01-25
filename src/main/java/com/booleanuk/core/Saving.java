package com.booleanuk.core;

public class Saving extends Account{
    private String type = "Saving account";
    public Saving(String type, double balance,Customer customer) {
        super(balance,customer);
        this.type = type;
    }
}
