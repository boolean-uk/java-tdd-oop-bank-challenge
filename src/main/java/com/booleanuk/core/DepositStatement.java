package com.booleanuk.core;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class DepositStatement extends Statement {

    public DepositStatement(Date date, double amount) {
        super(date, amount);
    }

    @Override
    public String toString() {
        return new SimpleDateFormat("dd/MM/yyyy").format(this.getDate()) + " || " + String.format("%.2f", this.getAmount()) + " ||        || ";
    }

}
