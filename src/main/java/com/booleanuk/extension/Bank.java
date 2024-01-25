package com.booleanuk.extension;

import java.util.ArrayList;
import java.util.Arrays;

public class Bank {
    ArrayList<Branch> branches;
    int funds;
    public Bank()
    {
        this.branches = new ArrayList<>(Arrays.asList(
            new Branch("Oslo_East", "Oslo"),
                new Branch("Trondheim_Central", "Trondheim"),
                new Branch("Bergen_West", "Bergen"),
                new Branch("Kristiansand_South", "Kristiansand"),
                new Branch("Lakselv_North", "Lakselv")
        ));
        this.funds = 999999999;
    }

    public Branch getBranch(String name)
    {
        for(Branch b : this.branches)
        {
            if(b.getName().equals(name)) return b;
        }
        System.out.println("Branch not found");
        return null;
    }

    public int getFunds()
    {
        return this.funds;
    }

    public void setFunds(int funds)
    {
        this.funds = funds;
    }

    public void newBranch(String name, String location)
    {
        this.branches.add(new Branch(name, location));
    }
}
