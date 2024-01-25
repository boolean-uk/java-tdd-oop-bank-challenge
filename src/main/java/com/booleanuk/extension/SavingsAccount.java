package com.booleanuk.extension;

import java.util.ArrayList;

public class SavingsAccount extends Account {
    public SavingsAccount(String name, String owner, int num, Bank bank)
    {
        super(name, bank);
        this.accountName  = name;
        this.accountID    = "sa-" + generateID(owner) + "-" + num;
        this.transactions = new ArrayList<>();
        this.balance      = 0;
        this.branch       = bank.getBranch("Oslo_East"); // Default branch in Oslo
        this.branch.addAccount(this.accountID);
    }
}
