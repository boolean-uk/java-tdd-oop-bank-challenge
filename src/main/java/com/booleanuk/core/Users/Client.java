package com.booleanuk.core.Users;

import com.booleanuk.core.Accounts.Account;

public class Client extends User {
    private Account currentAccount;
    private Account savingsAccount;

    public Client(String name, String phoneNumber) {
        super(name, phoneNumber);
        this.currentAccount = null;
        this.savingsAccount = null;
    }
    public boolean openSavingsAccount() {
        return true;
    }
    public boolean openCurrentAccount() {
        return true;
    }
}
