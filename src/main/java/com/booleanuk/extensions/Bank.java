package com.booleanuk.extensions;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private final List<Account> accounts;

    public Bank() {
        this.accounts = new ArrayList<>();
    }

    public void openCurrentAccount(Branch branch) {
        CurrentAccount currentAccount = new CurrentAccount(branch);
        accounts.add(currentAccount);
    }

    public void openSavingsAccount(Branch branch) {
        SavingsAccount savingsAccount = new SavingsAccount(branch);
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

    public void acceptOverdraftRequest(Account account) {
        if (account.getOverdraftRequested()) {
            account.acceptOverdraft();
        }
    }
}