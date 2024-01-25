package com.booleanuk.core;

public class CurrentAccount extends Account {
    public CurrentAccount(Customer customer, String branch) {
        super(customer,branch);
        this.type="Current account";
        customer.addAccount(this.type,this);
    }



    }