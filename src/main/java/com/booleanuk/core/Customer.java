package com.booleanuk.core;

import java.util.ArrayList;

public class Customer {
    private String name;
    private String email;
    private String address;
    private int personNr;
    ArrayList<Account> accounts;

    public Customer(String name, String email, String address, int personNr,ArrayList<Account> accounts) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.personNr = personNr;
        this.accounts = accounts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPersonNr() {
        return personNr;
    }

    public void setPersonNr(int personNr) {
        this.personNr = personNr;
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

}
