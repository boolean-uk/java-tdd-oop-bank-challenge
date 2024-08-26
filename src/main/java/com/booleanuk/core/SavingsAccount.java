package com.booleanuk.core;

public class SavingsAccount extends Account{

    SavingsAccount(AccountOwner owner) {
        super(owner);

    }

    @Override
    public String deposit(double amount) {

        Transaction depositTransaction = new Transaction(amount, 0, getBalance());
        getBankStatement().add(depositTransaction);

        setBalance(getBalance() + amount);

        return "New Balance: " + getBalance() + "£";
    }

    @Override
    public String withdraw(double amount) {
        if (amount <= getBalance()){
            Transaction withdrawTransaction = new Transaction(0, amount, getBalance());
            getBankStatement().add(withdrawTransaction);

            setBalance(getBalance() - amount);

            return "New Balance: " + getBalance() + "£";
        }

        else {
            return "Insufficient Funds";
        }

    }


}
