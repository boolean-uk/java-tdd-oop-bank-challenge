package com.booleanuk.core;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class SavingsAccount extends Account {

    public SavingsAccount(String ownerId, String branchId, String accountId) {
        this.transactions = new ArrayList<>();
        this.ownerId = ownerId;
        this.branchId = branchId;
        this.accountId = accountId;
    }


    @Override
    public int deposit(int sum) {
        return 0; // TODO
    }

    @Override
    public int deposit(Transaction transaction) {
        return 0;
    }

    @Override
    public int withdraw(int sum) {
        return 0; // TODO
    }

    @Override
    public int transfer(String targetAccountId, int sum) {
        return 0; // TODO
    }

    @Override
    public boolean isCurrentAccount() {
        return false;
    }
}
