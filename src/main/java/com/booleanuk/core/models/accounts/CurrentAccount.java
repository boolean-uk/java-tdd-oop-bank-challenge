package com.booleanuk.core.models.accounts;

import lombok.Getter;

import static com.booleanuk.core.util.Constants.MAX_OVERDRAFT_CURRENT;

@Getter
public class CurrentAccount extends Account {
    public CurrentAccount(int accountNumber) {
        super(accountNumber);
        this.maximumOverdraft = MAX_OVERDRAFT_CURRENT;
    }
}
