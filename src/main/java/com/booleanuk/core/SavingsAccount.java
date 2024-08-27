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
    public String deposit(int sum) {
        transactions.add(new Transaction(LocalDateTime.now().plusDays(3), "-1", this.accountId, sum));
        return String.format("The %.2f money will be deposited in three (3) days to the account %s.", (float) sum/100, this.accountId);
    }

    @Override
    public void deposit(Transaction transaction) {
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
