package com.booleanuk.core;

public class BankStatement {
    private BankAccount account;
    private double balanceBefore;
    private double balanceAfter;
    private String transactionDateTime;

    public BankStatement(BankAccount account, double balanceBefore, double balanceAfter,
                         String transactionDateTime) {
        this.account = account;
        this.balanceBefore = balanceBefore;
        this.balanceAfter = balanceAfter;
        this.transactionDateTime = transactionDateTime;
    }
}
