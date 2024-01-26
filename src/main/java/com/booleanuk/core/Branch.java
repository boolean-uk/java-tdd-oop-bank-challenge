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

    public String reviewOverdraftRequest(String accountId, boolean approve) {
        for(Map.Entry<Account, Double> entry : this.overdraftRequests.entrySet()) {
            if (entry.getKey().getAccountId().equals(accountId)) {
                if (approve) {
                    entry.getKey().setOverdraftLimit(entry.getValue());
                    return "Request for account "+accountId+" accepted";
                }
                return "Request for account "+accountId+" declined";
            }
        }
        return "No request found";
    }

    public Map<Account, Double> getOverdraftRequests() {
        return this.overdraftRequests;
    }

    public void addOverdraftRequest(Account account, double amount) {
        this.overdraftRequests.put(account, amount);
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
