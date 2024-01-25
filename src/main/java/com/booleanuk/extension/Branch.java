package com.booleanuk.extension;

import java.util.ArrayList;

public class Branch {
    private final String name;
    private final  String location;
    private ArrayList<String> accountIDs;
    private int funds;
    public Branch(String name, String location)
    {
        this.name = name;
        this.location = location;
        this.accountIDs = new ArrayList<>();
        this.funds = 10000;
    }

    public boolean addAccount(String accountID)
    {
        if(this.accountIDs.contains(accountID))
            return false;
        this.accountIDs.add(accountID);
        return true;
    }

    public boolean processOverdraftRequest(int amount)
    {
        return amount < this.funds;
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
