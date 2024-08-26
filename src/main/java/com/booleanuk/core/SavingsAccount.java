package com.booleanuk.core;

public class SavingsAccount extends Account{

    SavingsAccount(AccountOwner owner) {
        super(owner);

    }

    @Override
    public String deposit(double amount) {

        setBalance(getBalance() + amount);

        Transaction depositTransaction = new Transaction(TransactionType.DEPOSIT, amount, getBalance());
        getBankStatement().add(depositTransaction);



        return "New Balance: " + getBalance() + "£";
    }

    @Override
    public String withdraw(double amount) {
        if (amount <= getBalance()){

            setBalance(getBalance() - amount);

            Transaction withdrawTransaction = new Transaction(TransactionType.WITHDRAWAL, amount, getBalance());
            getBankStatement().add(withdrawTransaction);

            return "New Balance: " + getBalance() + "£";
        }

        else {
            return "Insufficient Funds";
        }

    }


}
