package com.booleanuk.extension;

import java.util.ArrayList;

public class CurrentAccount extends Account {

    public CurrentAccount(String name, String owner, int num, Bank bank)
    {
        super(name, bank);
        this.accountName = accountName;
        this.accountID = "cu-" + generateID(owner) + "-" + num;
        this.transactions = new ArrayList<>();
        this.balance = 0;
        this.branch       = bank.getBranch("Oslo_East");
        this.branch.addAccount(this.accountID);// Default branch in Oslo
    }
}
