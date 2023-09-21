package com.booleanuk.core;

import java.util.ArrayList;

public record Branch(String name, String address, String phone, ArrayList<BankAccount> accounts) {
    public boolean addAccount(BankAccount account){
        if (account.setBranch(this)){
            this.accounts.add(account);
            return true;
        }
        return false;
    }
}
