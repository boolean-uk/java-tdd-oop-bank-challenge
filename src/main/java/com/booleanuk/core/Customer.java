package com.booleanuk.core;

public class Customer {
    String name;

    public Customer(String name){
        this.name = name;
    }

    // Override equals and hashCode
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Customer customer = (Customer) obj;
        return name.equals(customer.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
