package com.booleanuk.core;

import java.util.ArrayList;

public class CurrentAccount extends Account{

    public CurrentAccount(String accountNr, String firstName, String lastName, String branch, double balance) {
        super(accountNr, firstName, lastName, "Current Account", branch, balance);
    }

}
