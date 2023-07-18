package com.booleanuk.core;

import java.math.BigDecimal;

public class Customer {
    private SavingsAccount savingsAccount;
    private CurrentAccount currentAccount;

    public Customer() {
    }

    public void createSavingsAccount(){
        if (checkIfAccountIsNull(savingsAccount)) {
            savingsAccount = new SavingsAccount();
            System.out.println("Savings account created ");
        }
        else
            throw new IllegalStateException("Savings account has already been created.");
    }

    public void createCurrentAccount(){
        if (checkIfAccountIsNull(currentAccount)) {
            currentAccount = new CurrentAccount();
            System.out.println("Current account created ");
        }
        else
            throw new IllegalStateException("Current account has already been created.");
    }

    public void addBalanceToCurrentAccount(BigDecimal addBalance){
        if (!checkIfAccountIsNull(currentAccount))
            currentAccount.addDeposit(addBalance);
        else
            throw new IllegalStateException("Current account does not exist.");
    }

    public void withDrawFromCurrentAccount(BigDecimal removeFromCurrentAccount){
        if (!checkIfAccountIsNull(currentAccount))
            currentAccount.withdraw(removeFromCurrentAccount);
        else
            throw new IllegalStateException("Current account does not exist.");
    }

    public void addBalanceToSavingsAccount(BigDecimal addBalance){
        if (!checkIfAccountIsNull(savingsAccount))
            savingsAccount.addDeposit(addBalance);
        else
            throw new IllegalStateException("Savings account does not exist.");
    }

    public void withDrawFromSavingsAccount(BigDecimal removeFromCurrentAccount){
        if (!checkIfAccountIsNull(savingsAccount))
            savingsAccount.withdraw(removeFromCurrentAccount);
        else
            throw new IllegalStateException("Savings account does not exist.");
    }

    public boolean checkIfAccountIsNull(Account account){
        return account == null;
    }
}
