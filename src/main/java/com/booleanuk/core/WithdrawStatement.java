package com.booleanuk.core;

import java.util.Date;

public class WithdrawStatement extends BankStatement {
    public WithdrawStatement(double amount, double balance) {
        super(amount, balance);
    }

    @Override
    protected String getStatementAsString() {

        return String.format("%-8s %2s %8s %2s %11s %9s\n",this.getTransactionDate(),"||", "500.0","||","||","2000.0");

    }
}
