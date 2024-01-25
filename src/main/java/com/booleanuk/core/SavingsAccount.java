package com.booleanuk.core;

import java.util.ArrayList;

public class SavingsAccount extends Account{

    public SavingsAccount(String accountNr, String firstName, String lastName, String branch, double balance) {
        super(accountNr, firstName, lastName, "Savings Account", branch, balance);
    }
}
