package com.booleanuk.core.accounts;

import com.booleanuk.core.users.Customer;

public class StandardAccount extends Account{

    private double maxOverdraft = 0.0;
    public StandardAccount(Customer user) {
        super(user);
    }

    public void setMaxOverdraft(double maxOverdraft) {
        this.maxOverdraft = maxOverdraft;
    }

    public double getMaxOverdraft() {
        return maxOverdraft;
    }
}
