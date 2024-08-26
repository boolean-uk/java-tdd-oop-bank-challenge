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

    public void addCurrentAccount(float firstDeposit, String branch) {
        CurrentAccount currentAccount = new CurrentAccount(firstDeposit, currentAccounts.size());
        currentAccounts.put(currentAccounts.size(), currentAccount);
        currentAccountsList.put("currentAccounts", currentAccounts);
        branches.put(branch, currentAccountsList);
    }

    public void addSavingAccount(float firstDeposit, String branch) {
        SavingAccount savingAccount = new SavingAccount(firstDeposit, savingAccounts.size());
        savingAccounts.put(savingAccounts.size(), savingAccount);
        savingAccountsList.put("savingAccounts", savingAccounts);
        branches.put(branch, savingAccountsList);
    }

    public Account getCurrentAccountWithIDInBranch(String branch, int id) {
        return branches.get(branch).get("currentAccounts").get(id);
    }

}
