package com.booleanuk.core;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DepositStatement extends BankStatement{
    public DepositStatement(double amount, double balance) {
        super(amount, balance);
    }

    @Override
    protected String getStatementAsString() {

        return String.format("%-8s %2s %11s %8s %2s %9s\n", this.getTransactionDate(),"||", "||",this.getAmount(),"||",this.getBalance());

    }
}
