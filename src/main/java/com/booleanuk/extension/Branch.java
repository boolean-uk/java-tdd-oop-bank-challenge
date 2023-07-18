package com.booleanuk.extension;

public class Branch {
    private final String id;
    private final String address;
    public String getId() {
        return id;
    }
    public String getAddress() {
        return address;
    }
    public Branch(String id, String address) {
        this.id = id;
        this.address = address;
    }
}
