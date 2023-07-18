package com.booleanuk.core;

public class NormalAccount  extends  BankAccount{

    private double debit;
    public NormalAccount( long accountNumber) {
        super(accountNumber);
        this.debit =500;
    }

    public double getDebit() {
        return debit;
    }

    public void setDebit(double debit) {
        this.debit = debit;
    }

    public boolean withdrawFromDebit(double amount)
    {
        return false;
    }
}
