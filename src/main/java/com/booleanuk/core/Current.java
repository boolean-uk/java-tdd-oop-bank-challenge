package com.booleanuk.core;

public class Current extends Account{
    private String type = "Current account";
    public Current(String type, double balance,Customer customer) {
        super(balance,customer);
        this.type = type;
    }
}
