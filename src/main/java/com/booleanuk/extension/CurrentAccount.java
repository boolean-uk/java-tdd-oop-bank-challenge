package com.booleanuk.extension;

public class CurrentAccount extends Account {
    public static final double OVERDRAFT = 500;

    private boolean overdraftAllowed = false;
    private boolean overdraftRequested = false;

    public CurrentAccount(Branch branch) {
        super(branch);
    }
    
    @Override
    public void withdraw(double amount) {
        if (!overdraftAllowed) super.withdraw(amount);

        if (amount < 0) {
            throw new IllegalArgumentException("Amount must be a positive number");
        }

        if (getBalance() + OVERDRAFT < amount) {
            throw new IllegalStateException("Amount must not exceed overdraft");
        }

        transactions.add(new Transaction(amount * -1));
    }

    public boolean isOverdraftAllowed() {
        return overdraftAllowed;
    }

    public boolean isOverdraftRequested() {
        return overdraftRequested;
    }

    public void requestOverdraft() {
        overdraftRequested = true;
    }

    public void approveOverdraft() {
        overdraftAllowed = true;
        overdraftRequested = false;
    }

    public void rejectOverdraft() {
        overdraftAllowed = false;
        overdraftRequested = false;
    }
}
