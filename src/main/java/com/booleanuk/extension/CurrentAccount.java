package com.booleanuk.extension;

import java.util.ArrayList;

public class CurrentAccount extends Account {

    public CurrentAccount(String name, String owner, int num)
    {
        super(name);
        this.accountName = accountName;
        this.accountID = "cu-" + generateID(owner) + "-" + num;
        this.transactions = new ArrayList<>();
        this.balance = 0;
    }
}
