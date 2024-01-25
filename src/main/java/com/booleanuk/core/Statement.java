package com.booleanuk.core;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Statement {
    private Date date;
    private double amount;

    public Statement(Date date, double amount) {
        this.date = date;
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Statement)) {
            return false;
        }

        Statement other = (Statement) obj;
        return this.date.equals(other.date) && this.amount == other.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, amount);
    }


}
