package com.booleanuk.core;

public class Client {
    private final String name;
    private final String clientId;

    public Client(String name, String clientId) {
        this.name = name;
        this.clientId = clientId;
    }

    public String getName() {
        return name;
    }

    public String getClientId() {
        return clientId;
    }
}
