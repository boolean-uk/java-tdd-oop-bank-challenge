package com.booleanuk.core;

public class Customer {
    private String name;
    private int id;
    private int noOfCreatedAccounts; //TODO: other soultion?

    public Customer(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getNoOfCreatedAccounts() {
        return noOfCreatedAccounts;
    }

    public void increaseNoOfCreatedAccounts() {
        noOfCreatedAccounts++;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Customer)) {
            return false;
        }

        Customer other = (Customer) obj;
        return this.id == other.id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }
}
