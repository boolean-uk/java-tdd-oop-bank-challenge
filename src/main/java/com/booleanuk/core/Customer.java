package com.booleanuk.core;

import java.util.ArrayList;

public class Customer {
    private String name;
    private String email;
    private String address;
    private int personNr;
    ArrayList<Account> accounts;

    public Customer(String name, String email, String address, int personNr) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.personNr = personNr;
        this.accounts = new ArrayList<>();
    }

    public ArrayList<Account> getAccounts() {
        return this.accounts;
    }


}
