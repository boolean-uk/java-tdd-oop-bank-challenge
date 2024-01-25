package com.booleanuk.extension;

import java.util.ArrayList;
import java.util.Arrays;

public class Bank {
    ArrayList<Branch> branches;
    public Bank()
    {
        this.branches = new ArrayList<>(Arrays.asList(
            new Branch("Oslo_East", "Oslo"),
                new Branch("Trondheim_Central", "Trondheim"),
                new Branch("Bergen_West", "Bergen"),
                new Branch("Kristiansand_South", "Kristiansand"),
                new Branch("Lakselv_North", "Lakselv")
        ));
    }

    public Branch getBranch(String id)
    {
        for(Branch b : this.branches)
        {
            if(b.getName().equals(id)) return b;
        }
        System.out.println("Branch not found");
        return null;
    }
}
