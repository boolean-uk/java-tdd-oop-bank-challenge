package com.booleanuk.core;

public class CurrentAccount extends Account {
    private boolean overDraftRequested;
    private double limit;
    private double requestedLimit;

    public CurrentAccount(int prefix, int accountNumber) {
        super(prefix, accountNumber);
        this.limit = 0.0;
        this.requestedLimit = 0.0;
        this.overDraftRequested = false;
    }

}
