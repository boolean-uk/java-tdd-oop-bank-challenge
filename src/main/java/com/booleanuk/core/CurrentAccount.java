package com.booleanuk.core;

import java.util.List;

public class CurrentAccount extends Account {
    public CurrentAccount(Branch branch, int accountNumber, Person accountOwner, double balance) {
        super(branch, accountNumber, accountOwner, balance);
    }
}
