package com.booleanuk.core;

public class Branch {
    private String branchId;
    private String name;
    private String location;

    public Branch(String branchId, String name, String location) {
        this.branchId = branchId;
        this.name = name;
        this.location = location;
    }

    public String getBranchId() {
        return this.branchId;
    }

    public String getName() {
        return this.name;
    }

    public String getLocation() {
        return this.location;
    }
}
