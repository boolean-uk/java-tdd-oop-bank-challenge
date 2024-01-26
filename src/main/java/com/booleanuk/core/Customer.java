package com.booleanuk.core;

public class Customer {
    private String customerId;
    private String name;
    private String phoneNumber;
    private String email;

    public Customer(String customerId, String name, String phoneNumber, String email) {
        this.customerId = customerId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getCustomerId() {
        return this.customerId;
    }
    public String getName() {
        return this.name;
    }
    public String getPhoneNumber() {
        return this.phoneNumber;
    }
    public String getEmail() {
        return this.email;
    }
}
