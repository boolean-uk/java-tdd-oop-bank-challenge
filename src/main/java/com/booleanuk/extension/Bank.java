package com.booleanuk.extension;

import java.util.ArrayList;

public class Bank {
    private final ArrayList<Account> accounts;

    public Bank() {
        this.accounts = new ArrayList<>();
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }
    public String overdraftApproval(Account account){
        if (account.getClass().getSimpleName().equals("CurrentAccount")){
            ((CurrentAccount) account).setOverdraft(true);
            return "Approved";
        }
        return "Rejected";
    }
}
