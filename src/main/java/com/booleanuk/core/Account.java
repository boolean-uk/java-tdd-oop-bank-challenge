package com.booleanuk.core;

import java.util.ArrayList;

public class Account {
    private String accountNr;
    private Branch branch;
    private ArrayList<Transfer> transfers;

    public Account(String accountNr, Branch branch) {
        this.accountNr = accountNr;
        this.branch = branch;
    }

    public String getAccountNr() {
        return accountNr;
    }

    public void setAccountNr(String accountNr) {
        this.accountNr = accountNr;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public ArrayList<Transfer> getTransfers() {
        return transfers;
    }

    public void setTransfers(ArrayList<Transfer> transfers) {
        this.transfers = transfers;
    }
}
