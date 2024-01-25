package com.booleanuk.core;

import java.util.List;

public class CurrentAccount extends Account {
    private int allowed_overdraft;
    public CurrentAccount(Branch branch, int accountNumber, Person accountOwner, double balance) {
        super(branch, accountNumber, accountOwner, balance);
        this.setAllowed_overdraft(0);
    }

    public void setAllowed_overdraft(int overdraft) {
        this.allowed_overdraft = overdraft;
    }
}
