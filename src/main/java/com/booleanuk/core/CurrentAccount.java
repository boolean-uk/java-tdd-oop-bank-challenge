package com.booleanuk.core;

import java.util.ArrayList;

public class CurrentAccount extends Account{

    public CurrentAccount(int id, String branch, Bank bank) {
        this.setId(id);
        this.setType("Saving");
        this.setBranch(branch);
        this.setTransactions(new ArrayList<>());
        this.setBank(bank);
    }
}
