package com.booleanuk.core;

import java.math.BigDecimal;

public class CurrentAccount extends BankAccount{
    private Overdraft overdraft;

    public CurrentAccount(String accountNumber, Branch branch) {
        super(accountNumber,branch);
        overdraft = new Overdraft();
    }



}
