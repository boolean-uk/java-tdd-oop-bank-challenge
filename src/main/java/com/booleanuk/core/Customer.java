package com.booleanuk.core;

import java.util.HashMap;

public class Customer {

    int id;
    String firstName;
    String lastName;
    HashMap<Integer,Account> Accounts;

    public Customer(int id, String firstName, String lastName, HashMap<Integer, Account> accounts) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        Accounts = accounts;
    }
}
