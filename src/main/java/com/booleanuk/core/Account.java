package com.booleanuk.core;

import java.time.LocalDateTime;
import java.util.ArrayList;

public abstract class Account implements Depositable {
    private ArrayList<Transaction> transactions;
    private String ownerId;
    private String branchId;
    private String accountId;

    public abstract int withdraw(int sum);
    public abstract int transfer(String targetAccountId, int sum);


    @Override
    public int deposit(int sum, LocalDateTime timeOfTransaction) {
        return 0;
    }
}
