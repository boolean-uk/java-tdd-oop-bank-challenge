package com.booleanuk.core.Accounts;

import com.booleanuk.core.Enums.Branches;
import com.booleanuk.core.Enums.Status;
import com.booleanuk.core.Users.User;

import java.math.BigDecimal;
import java.util.ArrayList;

public class CurrentAccount extends Account {
    public Status overdraftStatus;

    public CurrentAccount(BigDecimal initialBalance, Branches branch, User accountHolder) {
        super(initialBalance, branch, accountHolder);
    }

    public CurrentAccount(User accountHolder, Branches branch) {
        this.transactions = new ArrayList<>();
        this.accountHolder = accountHolder;
        this.branch = branch;
        this.setBalance(BigDecimal.ZERO);
    }

    @Override
    public boolean requestOverdraft() {
        return false;
    }
}
