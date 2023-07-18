package com.booleanuk.core;

public class NormalAccount extends BankAccount {

    private double maxDebit;

    public NormalAccount(long accountNumber) {
        super(accountNumber);
        this.setDebit(-500);
    }

    public NormalAccount(long accountNumber, String branch) {
        super(accountNumber, branch);
        this.setDebit(-500);
    }

    public double getDebit() {
        return maxDebit;
    }

    public void setDebit(double debit) {
        this.maxDebit = debit;
    }

    public void withdrawFromDebit(double amount) {


       this.setBalance(this.getBalance()-amount);
        this.getTransactions().add(new Transaction(amount, TransactionType.debit, this.getBalance()));
    }

    public boolean requestForOverdraft(double amount)
    {
        if(this.getManager().ApproveOverdraftRequest(this,amount))
        {
            withdrawFromDebit(amount);
            return true;
        }
        return false;
    }


}
