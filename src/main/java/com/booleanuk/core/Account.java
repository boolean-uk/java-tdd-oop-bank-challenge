package com.booleanuk.core;

import java.time.LocalDateTime;
import java.util.ArrayList;

public abstract class Account implements Depositable {
    protected ArrayList<Transaction> transactions;
    protected String ownerId;
    protected String branchId;
    protected String accountId;

    public abstract int withdraw(int sum);
    public abstract int transfer(String targetAccountId, int sum);


    @Override
    public int deposit(int sum, LocalDateTime timeOfTransaction) {
        return 0;
    }

    public String getAccountId() {
        return accountId;
    }
}
