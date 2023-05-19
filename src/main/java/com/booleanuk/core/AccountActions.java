package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class AccountActions {
    List<Integer> transactions = new ArrayList<>();
    List<Account> accounts = new ArrayList<>();

    public boolean createAccount(String accountType, String accountNumber, String accountHolderFirstName, String accountHolderLastName, String branchCode) {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                System.out.println("Could not create account because this account number is already in use");
                return false;
            }
        }


        return true;
    }

}
