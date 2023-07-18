package com.booleanuk.core.accounts;

import com.booleanuk.core.users.Customer;

public class StandardAccount extends Account{

    public StandardAccount(Customer user) {
        super(user);
    }

    public void setMaxOverdraft(double maxOverdraft) {
        this.maxOverdraft = Math.min(maxOverdraft, 0.0);
    }
}
