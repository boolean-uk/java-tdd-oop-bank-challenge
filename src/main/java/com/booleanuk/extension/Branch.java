package com.booleanuk.extension;

import java.util.ArrayList;
import java.util.HashMap;

public class Branch {
    private final String name;
    private String location;
    private ArrayList<String> accountIDs;
    HashMap<String, Integer> overdraftRequests;
    public Branch(String name, String location)
    {
        this.name = name;
        this.location = location;
        this.accountIDs = new ArrayList<>();
        this.overdraftRequests = new HashMap<>();
    }

    public boolean addAccount(String accountID)
    {
        if(this.accountIDs.contains(accountID))
            return false;
        this.accountIDs.add(accountID);
        return true;
    }

    public boolean addOverdraftRequest(String accountID, int amount)
    {
        this.overdraftRequests.put(accountID, amount);
        return true;
    }

    public ArrayList<String> getAccounts()
    {
        return this.accountIDs;
    }

    public String getName()
    {
        return this.name;
    }
}
