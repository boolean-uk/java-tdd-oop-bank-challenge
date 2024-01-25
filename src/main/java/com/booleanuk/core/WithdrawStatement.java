package com.booleanuk.core;

import java.text.SimpleDateFormat;
import java.util.Date;

public class WithdrawStatement extends Statement{

    public WithdrawStatement(Date date, double amount, double balance) {
        super(date, amount, balance);
    }

    @Override
    public String toString() {
        return new SimpleDateFormat("dd/MM/yyyy").format(this.getDate()) + " ||         || " + String.format("%.2f", this.getAmount()) + " || " + String.format("%.2f", this.getBalance());
    }

}
