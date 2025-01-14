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
        int balance = calculateBalance();
        if (balance < sum) {
            return String.format("Your balance of %.2f is too low to send a sum of %.2f.%n", (float) balance / 100, (float) sum / 100);
        }
        Depositable d = Controller.depositables.get(targetAccountId);
        Transaction t;
        if (d.isCurrentAccount()) {
            t = new Transaction(LocalDateTime.now(), this.accountId, targetAccountId, sum);
            d.deposit(t);
            transactions.add(t);
            return String.format("%.2f money has now been transferred from account %s to account %s.%n", (float) sum/100, this.accountId, targetAccountId);
        } else {
            t = new Transaction(LocalDateTime.now().plusDays(3), this.accountId, targetAccountId, sum);
            Controller.depositables.get(targetAccountId).deposit(t);
            transactions.add(t);
            return String.format("%.2f money will be transferred from account %s to account %s in three (3) days.%n", (float) sum/100, this.accountId, targetAccountId);
        }
    }

    @Override
    public boolean isCurrentAccount() {
        return true;
    }
}
