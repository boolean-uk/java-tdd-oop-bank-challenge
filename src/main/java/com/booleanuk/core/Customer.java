package com.booleanuk.core;

public class Customer {

    String name;

    public  Customer(String name) {
        this.name = name;
    }

    public boolean requestCurrentAccount() {
        return createCurrentAccount(this);
    }

}
