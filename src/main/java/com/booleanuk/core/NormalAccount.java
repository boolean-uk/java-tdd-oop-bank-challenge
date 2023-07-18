package com.booleanuk.core;

public class NormalAccount extends BankAccount {

    private double debit;

    public NormalAccount(long accountNumber) {
        super(accountNumber);
        this.setDebit(500);
    }

    public NormalAccount(long accountNumber, String branch) {
        super(accountNumber, branch);
        this.setDebit(500);
    }

    public double getDebit() {
        return debit;
    }

    public void setDebit(double debit) {
        this.debit = debit;
    }

    public boolean withdrawFromDebit(double amount) {
        if (debit >= amount&& amount>0) {

            this.getTransactions().add(new Transaction(amount, TransactionType.debit, this.getBalance() - amount));
            this.setBalance(this.getBalance()-amount);
            if(this.getBalance()<0) {
                debit += this.getBalance();
            }
            return true;
        }
        return false;
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
