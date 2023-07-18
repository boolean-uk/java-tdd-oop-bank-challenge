package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private String fullName;
    private List<Account> accounts;

    public Customer(String fullName) {
        this.fullName = fullName;
        this.accounts = new ArrayList<>();
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void createAccount(String typeOfAccount){
        if(typeOfAccount.equalsIgnoreCase("saving")){
            SavingAccount savingAccount = new SavingAccount(typeOfAccount);
            accounts.add(savingAccount);
        } else if(typeOfAccount.equalsIgnoreCase("current")){
            CurrentAccount currentAccount = new CurrentAccount(typeOfAccount);
            accounts.add(currentAccount);
        }
        throw new RuntimeException("We don't have this type of account, sorry!");
    }
}
