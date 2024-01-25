package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Account> accounts;

    public Bank() {
        this.accounts = new ArrayList<>();
    }

    public void openCurrentAccount() {
        CurrentAccount currentAccount = new CurrentAccount();
        accounts.add(currentAccount);
    }

    public void openSavingsAccount() {
        SavingsAccount savingsAccount = new SavingsAccount();
        accounts.add(savingsAccount);
    }

    public void depositToAccount(Account account, double amount) {
        account.deposit(amount);
    }

    public void withdrawFromAccount(Account account, double amount) {
        account.withdraw(amount);
    }

    public List<Account> getAccounts() {
        return accounts;
    }
}