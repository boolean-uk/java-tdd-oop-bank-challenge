package com.booleanuk.core;

import java.util.ArrayList;

public class SavingsAccount extends Account{

    public SavingsAccount(int id, String branch) {
        this.setId(id);
        this.setType("Saving");
        this.setBranch(branch);
        this.setTransactions(new ArrayList<>());
        //this.setInterest(5);
    }
}
