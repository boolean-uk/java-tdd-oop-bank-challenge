package com.booleanuk.core;

import java.util.*;

public class Bank {



    public static void main(String[] args){
        Bank bank = new Bank();
        int savingsAccountId = bank.createAccount("Alpha Bank West Side", AccountType.SAVINGS, 10500.0);
        int currentAccountId = bank.createAccount("Alpha Bank West Side", AccountType.CURRENT, 3200.0);

        bank.getAccounts().get(savingsAccountId).withdraw(4700.0);
        bank.getAccounts().get(currentAccountId).withdraw(3400);
        bank.requestOverdraft(currentAccountId);

        bank.getAccounts().get(currentAccountId).withdraw(4000);

        bank.evaluateOverdraftRequest(currentAccountId, OverdraftStatus.ACCEPTED);
        bank.getAccounts().get(currentAccountId).withdraw(5000);


        bank.getAccounts().get(savingsAccountId).deposit(12200.0);

        bank.requestOverdraft(savingsAccountId);

        bank.getAccounts().get(savingsAccountId).withdraw(120000);


        bank.generateStatement(currentAccountId).print();
        System.out.println("\n\n");
        bank.generateStatement(savingsAccountId).print();

    }
    public enum AccountType {
        CURRENT,
        SAVINGS
    }

    public enum OverdraftStatus {
        NON_APPLICABLE,
        NONE,
        PENDING,
        ACCEPTED,
        REJECTED
    }

    private Map<Integer, Account> accounts;

    public Bank(){
        this.accounts = new HashMap<>();
    }

    public Map<Integer, Account> getAccounts() {
        return accounts;
    }


    public int createAccount(String branch, AccountType accountType, double initialBalance) {
        Account newAccount = AccountType.CURRENT.equals(accountType) ?
                new CurrentAccount(branch, initialBalance) :
                new SavingsAccount(branch, initialBalance);
        accounts.put(newAccount.getId(), newAccount);

        return newAccount.getId();
    }

    public BankStatement generateStatement(int accountId){
        if(!accounts.containsKey(accountId)) return null;
        return new BankStatement(accounts.get(accountId));
    }

    public boolean requestOverdraft(int accountId){
        if(!accounts.containsKey(accountId)) return false;
        if(accounts.get(accountId).getOverdraftStatus().equals(OverdraftStatus.NON_APPLICABLE)) return false;
        if(accounts.get(accountId).getOverdraftStatus().equals(OverdraftStatus.PENDING)) return false;

        accounts.get(accountId).setOverdraftStatus(OverdraftStatus.PENDING);
        return true;
    }

    public void evaluateOverdraftRequest(int accountId, OverdraftStatus updatedStatus){
        if(updatedStatus.equals(OverdraftStatus.PENDING)) return;
        if(!getAccounts().containsKey(accountId)) return;
        if(!getAccounts().get(accountId).getOverdraftStatus().equals(OverdraftStatus.PENDING)) return;

        getAccounts().get(accountId).setOverdraftStatus(updatedStatus);

    }

}
