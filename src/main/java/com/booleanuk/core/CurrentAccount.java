package com.booleanuk.core;

public class CurrentAccount extends Account {
    public CurrentAccount(Customer customer) {
        super(customer);
        this.type="Current account";
        customer.addAccount(this.type,this);
    }



    }