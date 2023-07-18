package com.booleanuk.core;

import java.time.LocalDate;
import java.util.ArrayList;

public class Account {
    private String accountNr;
    private Branch branch;
    private ArrayList<Transfer> transfers;

    public Account(String accountNr, Branch branch) {
        this.accountNr = accountNr;
        this.branch = branch;
        this.transfers = new ArrayList<Transfer>();
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

    public int calculateBalance() {
        int sum = 0;
        for (Transfer transfer : transfers) {
            if (transfer.getClass().isInstance(Withdraw.class)) sum -= transfer.getAmountOfMoney();
            else sum += transfer.getAmountOfMoney();
        }
        return sum;
    }

    public void deposit(int amountOfMoney) {
        transfers.add(new Deposit(amountOfMoney, LocalDate.now()));
    }
}
