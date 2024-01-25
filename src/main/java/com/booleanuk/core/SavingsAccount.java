package com.booleanuk.core;

public class SavingsAccount extends Account{
    public SavingsAccount(int accountId, BankStatementGenerator bankStatementGenerator) {
        super(accountId, bankStatementGenerator);
    }

    @Override
    public void withdraw(double amount) {
        double balance = this.getBalance();
        if(amount <= balance) {
            super.withdraw(amount);
        }
    }
}
