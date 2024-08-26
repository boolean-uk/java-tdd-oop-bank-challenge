package com.booleanuk.core;

import java.util.HashMap;

public class BankManager {

    //Branch -> Type of account -> account
    private HashMap<String, HashMap<String, HashMap<Integer, Account>>> branches;
    private HashMap<String, HashMap<Integer, Account>> AccountsList;
    private HashMap<Integer, Account> accounts;
    private float overdraftLimit = -250;

    public BankManager() {
        branches = new HashMap<>();
        AccountsList = new HashMap<>();
        accounts = new HashMap<>();

    }

    public void addAccount(float firstDeposit, String typeOfAccount, String branch) {
        CurrentAccount currentAccount = new CurrentAccount(firstDeposit);
        accounts.put(accounts.size(), currentAccount);
        AccountsList.put(typeOfAccount, accounts);
        branches.put(branch, AccountsList);
    }

    public Account getCurrentAccountWithIDInBranch(String branch, String typeOfAccount, int id) {
        return branches.get(branch).get(typeOfAccount).get(id);
    }

    public boolean withdrawFromAccount(Account account, float amount) {
        if((account.getBalance() - amount) >= this.overdraftLimit) {
            account.withdrawMoney(amount, this.overdraftLimit);
            return true;
        }else {
            return false;
        }
    }

}
