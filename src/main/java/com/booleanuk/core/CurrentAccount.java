package com.booleanuk.core;

import java.math.BigDecimal;

public class CurrentAccount extends Account {
    private boolean overdraftRequestPending;
    private BigDecimal requestedOverdraftAmount;

    public CurrentAccount(String accountNumber,Client client) {
        super(accountNumber,client);
        this.overdraftLimit = BigDecimal.ZERO;
        overdraftRequestPending = false;
        requestedOverdraftAmount = BigDecimal.ZERO;

    }

    @Override
    public void deposit(BigDecimal amount) {
        balance = balance.add(amount);
        transactions.add(new Transaction(generateRandomDateTime(), amount, TransactionType.DEPOSIT));
    }

    @Override
    public void withdraw(BigDecimal amount) {
        if (balance.compareTo(amount) >= 0) {
            balance = balance.subtract(amount);
            transactions.add(new Transaction(generateRandomDateTime(), amount, TransactionType.WITHDRAWAL));
        } else {
            System.out.println("Insufficient funds!");
        }
    }
    @Override
    public BigDecimal getBalance() {
        return balance;
    }
    public boolean isOverdraftRequestPending() {
        return overdraftRequestPending;
    }

    public void setOverdraftRequestPending(boolean overdraftRequestPending) {
        this.overdraftRequestPending = overdraftRequestPending;
    }

    public BigDecimal getRequestedOverdraftAmount() {
        return requestedOverdraftAmount;
    }

    public void requestOverdraft(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) > 0) {
            requestedOverdraftAmount = amount;
            overdraftRequestPending = true;
            System.out.println("Overdraft request of " + amount + " has been submitted.");
        } else {
            System.out.println("Invalid overdraft amount. The amount should be greater than zero.");
        }
    }

    public void approveOverdraftRequest() {
        if (overdraftRequestPending) {
            balance = balance.subtract(requestedOverdraftAmount);
            overdraftRequestPending = false;
            System.out.println("Overdraft request approved. Debited " + requestedOverdraftAmount + " from the account.");
        } else {
            System.out.println("No overdraft request is pending for this account.");
        }
    }

    public void rejectOverdraftRequest() {
        if (overdraftRequestPending) {
            overdraftRequestPending = false;
            System.out.println("Overdraft request rejected.");
        } else {
            System.out.println("No overdraft request is pending for this account.");
        }
    }
}
