package com.booleanuk.core;

import java.util.Date;

public class BankStatement {

    private String transactionDate;
    private double amount;
    private double balance;

    public BankStatement(String transactionDate, double amount, double balance) {
        this.transactionDate = transactionDate;
        this.amount = amount;
        this.balance = balance;
    }

    public String generateBankStatement(BankAffiliate bankAffiliate) {
        String bankStatementOutput = "";

        /*
        bankStatementOutput += "date       || credit  || debit  || balance"
                            += this.transactionDate + "       || "
                            += this.amount + "       || "
                            += this.amount + "       || "
                            += this.balance; */

        return bankStatementOutput;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
