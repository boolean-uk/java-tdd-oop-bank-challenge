package com.booleanuk.core;

import java.util.ArrayList;

public class CurrentAccount extends Account {

    public CurrentAccount(String name, String owner, int num)
    {
        super(name);
        this.accountName = name;
        this.accountID = "cu-" + generateID(owner) + "-" + num;
        this.transactions = new ArrayList<>();
        this.balance = 0;
    }
}
