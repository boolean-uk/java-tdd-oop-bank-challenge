package com.booleanuk.core;

import java.util.ArrayList;

public class Customer {
    private final ArrayList<Account> accounts;


    public Customer() {
        this.accounts = new ArrayList<>();
    }


    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public boolean createAccount(Account account) {
        this.accounts.add(account);
        return true;
    }


    public Account getAccount(Account currentAccount) {
        return this.accounts.stream().filter(account -> account == currentAccount).findFirst().orElse(null);
    }

    public boolean deleteAccount(Account savingsAccount) {
        this.accounts.remove(savingsAccount);
        return true;
    }


    public boolean deposit(Account account, double v) {
        account.deposit(v);
        return true;
    }



    public boolean withdraw(Account account, double v) {
        account.withdraw(v);
        return true;
    }


    public boolean transferCredit(Account account1, Account account2, double credit) {

        if(account1.getBalance() >= credit) {
            account1.withdraw(credit);
            account2.deposit(credit);
            return true;
        }

        return false;
    }

    public String printBankStatements(Account account) {
        return "";
    }

    public boolean requestOverdraft(CurrentAccount currentAccount, BankManager bankManager) {

        return true;
    }
}
