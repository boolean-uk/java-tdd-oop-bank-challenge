package com.booleanuk.extension;

import java.util.ArrayList;

public class Branch {
    String name;
    String location;
    ArrayList<String> accountIDs;
    public Branch(String name, String location)
    {
        this.name = name;
        this.location = location;
        this.accountIDs = new ArrayList<>();
    }

    public boolean addAccount(String accountID)
    {
        if(this.accountIDs.contains(accountID))
            return false;
        this.accountIDs.add(accountID);
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
