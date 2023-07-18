package com.booleanuk.core;

import java.util.UUID;

public class Customer {
    private UUID id;

    public Customer() {
        this.id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }
}
