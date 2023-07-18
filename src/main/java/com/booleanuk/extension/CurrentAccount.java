package com.booleanuk.extension;

public class CurrentAccount extends Account {
    private boolean overdraftAllowed = false;
    private boolean overdraftRequested = false;

    public CurrentAccount(Branch branch) {
        super(branch);
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
        overdraftRequested = true;
    }
}
