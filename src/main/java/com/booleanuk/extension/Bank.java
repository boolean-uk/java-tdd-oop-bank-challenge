package com.booleanuk.extension;

import java.util.ArrayList;

public class Bank {
    private final ArrayList<Account> accounts;
    private final ArrayList<Account> overdraftRequests;

    public Bank() {

        this.accounts = new ArrayList<>();
        this.overdraftRequests = new ArrayList<>();
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public ArrayList<Account> getOverdraftRequests() {
        return overdraftRequests;
    }

    public void requestOverdraft(Account account) {
        this.overdraftRequests.add(account);
    }

    public String overdraftApproval(Account account) {
        if (this.overdraftRequests.contains(account)) {
            if (account.getClass().getSimpleName().equals("CurrentAccount")) {
                ((CurrentAccount) account).setOverdraft(true);
                return "Approved";
            } else {
                return "Rejected";
            }
        }
        return "Invalid request";
    }
}
