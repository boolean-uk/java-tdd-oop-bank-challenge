package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private static final List<Account> accountList = new ArrayList<>();
    public static Account getAccount(String accountNumber){
        return accountList.stream()
                .filter(account -> account.getAccountNumber().equals(accountNumber))
                .findFirst()
                .orElseThrow();
    }

    public static List<Account> getAccountList() {
        return accountList;
    }
}
