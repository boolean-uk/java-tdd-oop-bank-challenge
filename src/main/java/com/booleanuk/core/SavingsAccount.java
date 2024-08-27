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
    public int withdraw(int sum) {
        return 0; // TODO
    }

    @Override
    public String transfer(String targetAccountId, int sum) {
        if (calculateBalance(3) < sum) {
            return String.format("Not enough balance in 3 days to transfer %.2f money. Please deposit more money first.", (float) sum/100);
        } else {
            Transaction t = new Transaction(LocalDateTime.now().plusDays(3), this.accountId, targetAccountId, sum);
            Controller.depositables.get(targetAccountId).deposit(t);
            transactions.add(t);
            return String.format("%.2f money will be transferred from account %s to account %s in three (3) days.", (float) sum/100, this.accountId, targetAccountId);
        }
    }

    @Override
    public boolean isCurrentAccount() {
        return false;
    }
}
