package com.booleanuk.core.Accounts;

import com.booleanuk.core.Enums.Branches;
import com.booleanuk.core.Enums.Status;
import com.booleanuk.core.Users.User;

import java.math.BigDecimal;

public class CurrentAccount extends Account{
    public Status overdraftStatus;
    public CurrentAccount(BigDecimal balance, Branches branch, User accountHolder) {
        super(balance, branch, accountHolder);
    }

    public void requestOverdraft() {

    }
}
