package com.booleanuk.core;

public class Customer {
    private Account[] accounts;
    private int id;
    public Customer(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Customer)) return false;
        Customer other = (Customer) obj;
        return id == other.id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }
}
