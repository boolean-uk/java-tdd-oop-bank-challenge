package com.booleanuk.core;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class CurrentAccount extends Account {

    public CurrentAccount(String ownerId, String branchId, String accountId) {
        this.transactions = new ArrayList<>();
        this.ownerId = ownerId;
        this.branchId = branchId;
        this.accountId = accountId;
    }


    @Override
    public String deposit(int sum) {
        transactions.add(new Transaction(LocalDateTime.now(), "-1", this.accountId, sum));
        return String.format("The %.2f money is now deposited to the account %s.%n", (float) sum/100, this.accountId);
    }

    public String withdraw(int sum) {
        int balance = calculateBalance();
        if (sum > balance) {
            return String.format("Your balance of %.2f is too low to withdraw a sum of %.2f.%n", (float) balance / 100, (float) sum / 100);
        }
        transactions.add(new Transaction(LocalDateTime.now(), accountId, "-1", sum));
        return String.format("%.2f money has been withdrawn from your account.%n", (float) sum / 100);

    }

    @Override
    public String transfer(String targetAccountId, int sum) {
        return ""; // TODO
    }

    @Override
    public boolean isCurrentAccount() {
        return true;
    }
}
