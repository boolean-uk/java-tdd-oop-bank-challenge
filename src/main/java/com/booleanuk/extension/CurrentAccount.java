package com.booleanuk.extension;

import java.util.ArrayList;

public class CurrentAccount extends Account {

    public CurrentAccount(String name, String owner, int num, Bank bank)
    {
        super(name, bank);
        this.accountName  = name;
        this.accountID    = "cu-" + generateID(owner) + "-" + num;
        this.transactions = new ArrayList<>();
        this.branch       = bank.getBranch("Oslo_East"); // Default branch in Oslo
        this.branch.addAccount(this.accountID);
    }
}
