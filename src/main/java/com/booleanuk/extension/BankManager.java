package com.booleanuk.extension;

public class BankManager {

    String fullName;

    public BankManager(String fullName) {
        this.fullName = fullName;
    }

    // only current accounts can have overdraft
    public boolean changeStatusOfOverDraftRequest(Customer customer, String accountNumber) {
        Account currentAccount = customer.getAllAccounts().stream()
                .filter(account -> account.getTypeOfAccount().equals("current"))
                .filter(account -> account.getAccountNumber().equals(accountNumber))
                .findFirst()
                .get();

        if (currentAccount instanceof CurrentAccount) {
            ((CurrentAccount) currentAccount).setOverdraft(true);
            return true;
        }
        return false;
    }
}
