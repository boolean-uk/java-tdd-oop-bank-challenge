package com.booleanuk.extension;

import java.util.ArrayList;

public class SavingsAccount extends Account {
    public SavingsAccount(String name, String owner, int num)
    {
        super(name);
        this.accountName = accountName;
        this.accountID = "sa-" + generateID(owner) + "-" + num;
        System.out.println(accountID);
        this.transactions = new ArrayList<>();
        this.balance = 0;
    }
}
