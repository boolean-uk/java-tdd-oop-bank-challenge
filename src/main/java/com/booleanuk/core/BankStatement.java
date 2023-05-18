package com.booleanuk.core;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BankStatement {
    private Date date;
    private double credit;
    private double debit;
    private double balance;

    public BankStatement() {
        this.date = new Date();
    }

    public void withdraw(double debit, double balance) {
        this.debit = debit;
        this.balance = balance - debit;
    }

    public void deposit(double credit, double balance) {
        this.credit = credit;
        this.balance = balance + credit;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return new SimpleDateFormat("dd/MM/yyyy").format(date) + "||" + credit + "||" + debit + "||" + balance;
    }
}
