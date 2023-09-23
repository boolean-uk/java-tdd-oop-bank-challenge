package com.booleanuk.core.Users;

import com.booleanuk.core.Accounts.Account;
import com.booleanuk.core.Accounts.CurrentAccount;
import com.booleanuk.core.Accounts.SavingsAccount;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Client extends User {
    private Account currentAccount;
    private Account savingsAccount;

    public Client(String name, String phoneNumber) {
        super(name, phoneNumber);
        this.currentAccount = null;
        this.savingsAccount = null;
    }
    public boolean openSavingsAccount() {
        if (this.savingsAccount != null) {
            // Savings account is already open for this user
            System.out.println("You already have a savings account.");
            return false;
        } else {
            // Open a new savings account
            this.savingsAccount = new SavingsAccount(/* constructor parameters */);
            return true;
        }
    }
    public boolean openCurrentAccount() {
        if (currentAccount != null) {
            // Current account is already open for this user
            System.out.println("You already have a current account.");
            return false;
        } else {
            // Open a new current account
            currentAccount = new CurrentAccount(/* constructor parameters */);
            return true;
        }
    }
    public boolean requestOverdraft() {
        return false;
    }
}
