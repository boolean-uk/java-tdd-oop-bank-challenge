package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class Manager {
    final static List<Account> overdraftRequests = new ArrayList<>();

    public static void overdraftRequest(Account account) {
        overdraftRequests.add(account);
    }

    public static void acceptRequest(Account account, boolean accepted) {
        account.overdraft = accepted;
    }
}
