package com.booleanuk.extension;

import java.util.UUID;

public class Customer {
    private final UUID id;
    private String phoneNumber;

    public Customer() {
        this.id = UUID.randomUUID();
    }

    public Customer(String phoneNumber) {
        this();
        this.phoneNumber = phoneNumber;
    }

    public UUID getId() {
        return id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
