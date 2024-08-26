package com.booleanuk.core;

public class CurrentAccount extends Account{

    private double overdraftLimit;

    CurrentAccount(AccountOwner owner) {
        super(owner);

        //Setting overdraft as 1000 for now
        this.overdraftLimit = 1000.0;
    }

    public double getOverdraftLimit(){
        return overdraftLimit;
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
        if (amount <= getBalance() + overdraftLimit){

            if (amount > getBalance()){
                double overdraft = amount - getBalance();

                overdraftLimit -= overdraft;
            }

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
