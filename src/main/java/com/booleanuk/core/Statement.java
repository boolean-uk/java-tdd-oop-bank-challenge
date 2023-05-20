package com.booleanuk.core;

public class Statement {

    private int customerId;
    private int accountId;
    private int credit;
    private int debit;

    public Statement (int customerId, int accountId, int credit, int debit) {
        this.customerId = customerId;
        this.accountId = accountId;
        this.credit = credit;
        this.debit = debit;
    }

    //Getters
    public int getCustomerId() {
        return customerId;
    }

    public int getAccountId() {
        return accountId;
    }

    public int getCredit() {
        return credit;
    }

    public int getDebit() {
        return debit;
    }


}
