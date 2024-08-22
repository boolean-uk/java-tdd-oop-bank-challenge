package com.booleanuk.core;

import java.util.ArrayList;

public class CurrentAccount extends Account{

    public CurrentAccount(int id, String branch) {
        this.setId(id);
        this.setType("Saving");
        this.setBranch(branch);
        this.setTransactions(new ArrayList<>());
    }
}
