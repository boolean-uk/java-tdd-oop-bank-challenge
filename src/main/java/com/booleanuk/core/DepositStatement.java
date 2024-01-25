package com.booleanuk.core;

import java.util.Date;

public class DepositStatement extends BankStatement{
    public DepositStatement(Date date, double amount, double balance) {
        super(date, amount, balance);
    }

    @Override
    protected String getStatementAsString() {

        return "";
    }
}
