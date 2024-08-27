package com.booleanuk.core;

import java.util.HashMap;

public class BankManager {

    //Branch -> Type of account -> account
    private HashMap<String, HashMap<String, HashMap<Integer, Account>>> branches;
    private HashMap<String, HashMap<Integer, Account>> accountsList;
    private HashMap<Integer, Account> accounts;

    public BankManager() {
        branches = new HashMap<>();
        accountsList = new HashMap<>();
        accounts = new HashMap<>();

    }

    public boolean addAccount(float firstDeposit, String typeOfAccount, String branch) {
        if(typeOfAccount.equals("currentAccount")) {
            CurrentAccount currentAccount = new CurrentAccount(firstDeposit, branch);
            accounts.put(accounts.size(), currentAccount);
            accountsList.put(typeOfAccount, accounts);
            branches.put(branch, accountsList);
            return true;
        }else if (typeOfAccount.equals("savingAccount")) {
            SavingAccount savingAccount = new SavingAccount(firstDeposit, branch);
            accounts.put(accounts.size(), savingAccount);
            accountsList.put(typeOfAccount, accounts);
            branches.put(branch, accountsList);
            return true;
        }else {
            System.out.println("Cannot make " + typeOfAccount + " in our bank");
            return false;
        }

    }

    public Account getCurrentAccountWithIDInBranch(String branch, String typeOfAccount, int id) {
        return branches.get(branch).get(typeOfAccount).get(id);
    }

    public boolean withdrawFromAccount(Account account, float amount) {
        if((account.getBalance() - amount) >= account.getOverdraftLimit()) {
            account.withdrawMoney(amount);

            return true;
        }else {
            return false;
        }
    }

    public boolean canAccountOverdraft(Account account) {
        account.setCanOverdraft();
        return account.getCanOverdraft();
    }
}
