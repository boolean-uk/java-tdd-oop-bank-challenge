package com.booleanuk.core;

import java.util.UUID;

public class Customer {
    private final UUID id;

    public Customer() {
        this.id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }
}
