package com.booleanuk.core;

import java.util.HashMap;
import java.util.Map;

public class Branch {
    private String branchId;
    private String name;
    private String location;
    private Map<Account, Double> overdraftRequests;

    public Branch(String branchId, String name, String location) {
        this.branchId = branchId;
        this.name = name;
        this.location = location;
        this.overdraftRequests = new HashMap<>();
    }

    public Map<Account, Double> getOverdraftRequests() {
        return this.overdraftRequests;
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
