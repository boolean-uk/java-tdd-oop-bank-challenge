package com.booleanuk.core;

import java.util.Date;

public class WithdrawStatement extends BankStatement {
    public WithdrawStatement(Date date, double amount, double balance) {
        super(date, amount, balance);
    }

    @Override
    protected String getStatementAsString() {
        return "";
    }
}
