package com.booleanuk.core;

import java.util.ArrayList;

public class NorwayBranch implements Branch {

    private final ArrayList<Account> accounts = new ArrayList<>();
    private final int prefix = 1;


    @Override
    public void handleOverdraftRequest(double amountInKroner, Account account) {

    //Want the limit to be 1000
    }

    @Override
    public void createAndAddAccount(int accountNumber, Type type) {
        if (type.equals(Type.SAVINGS)) {
            this.accounts.add(new SavingsAccount(this.prefix, accountNumber));
        } else if (type.equals(Type.CURRENT)) {
            this.accounts.add(new CurrentAccount(this.prefix, accountNumber));
        } else {
            System.out.println("Invalid account type!");
        }
    }

    public ArrayList<Account> getAccounts() {
        return this.accounts;
    }


}
