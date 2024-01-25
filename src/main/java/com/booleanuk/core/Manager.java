package com.booleanuk.core;

public class Manager extends Person {
    public Manager(String name, int UID) {
        super(name, UID);
    }

    public boolean setCreditScore(Customer customer, CreditScore creditScore) {
        try {
        customer.setCreditScore(creditScore);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
