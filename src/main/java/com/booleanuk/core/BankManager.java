package com.booleanuk.core;

import java.util.HashMap;

public class BankManager {

    //Branch -> Type of account -> account
    HashMap<String, HashMap<String, HashMap<Integer, Account>>> branches;
    HashMap<String, HashMap<Integer, Account>> currentAccountsList;
    HashMap<String, HashMap<Integer, Account>> savingAccountsList;
    HashMap<Integer, Account> currentAccounts;
    HashMap<Integer, Account> savingAccounts;

    public BankManager() {
        branches = new HashMap<>();
        currentAccountsList = new HashMap<>();
        savingAccountsList = new HashMap<>();
        currentAccounts = new HashMap<>();
        savingAccounts = new HashMap<>();

    }

    public void addAccount(float firstDeposit, String typeOfAccount, String branch) {
        CurrentAccount currentAccount = new CurrentAccount(firstDeposit);
        currentAccounts.put(currentAccounts.size(), currentAccount);
        currentAccountsList.put(typeOfAccount, currentAccounts);
        branches.put(branch, currentAccountsList);
    }

    public Account getCurrentAccountWithIDInBranch(String branch, String typeOfAccount, int id) {
        return branches.get(branch).get(typeOfAccount).get(id);
    }

}
