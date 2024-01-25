package com.booleanuk.core;

import java.util.ArrayList;

public class Account {
    private ArrayList<Transaction> transactions;
    private final int monthlyMaxWithdrawalCount;
    private final double maxBalance;

    private int currentWithdrawalCount;

    public Account(int monthlyMaxWithdrawalCount, double maxBalance) {
        this.monthlyMaxWithdrawalCount = monthlyMaxWithdrawalCount;
        this.maxBalance = maxBalance;
    }

    protected double getBalance() {
        return 0.0;
    }

    public Status deposit(double credit) {
        return Status.ERROR;
    }

    public Status withdraw(double credit) {
        return Status.ERROR;
    }

    public Transaction[] getBankStatement() {
        return new Transaction[]{};
    }

    public boolean hasExceededMonthlyWithdrawal() {
        return monthlyMaxWithdrawalCount <= currentWithdrawalCount;
    }
}
