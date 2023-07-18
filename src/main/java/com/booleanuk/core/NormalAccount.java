package com.booleanuk.core;

public class NormalAccount extends BankAccount {

    private double debit;

    public NormalAccount(long accountNumber) {
        super(accountNumber);
        this.debit = 500;
    }
    public NormalAccount(long accountNumber,String branch) {
        super(accountNumber,branch);
        this.debit = 500;
    }

    public double getDebit() {
        return debit;
    }

    public void setDebit(double debit) {
        this.debit = debit;
    }

    public boolean withdrawFromDebit(double amount) {
        if (debit >= amount) {
            this.getTransactions().add(new Transaction(amount, TransactionType.credit, this.getBalance() - debit));
            debit -= amount;
            this.setBalance(this.getBalance() - amount);
            return true;
        }
        return false;
    }

    public static void main(String[] args)
    {
        NormalAccount normalAccount = new NormalAccount(123123);
        normalAccount.deposit(123);
        normalAccount.generateStatement();
    }
}
