package com.booleanuk.extensions;

public class CurrentAccount extends Account {
    boolean approvedOverdraft;

    public CurrentAccount() {
        super();
        approvedOverdraft = false;
    }
}
