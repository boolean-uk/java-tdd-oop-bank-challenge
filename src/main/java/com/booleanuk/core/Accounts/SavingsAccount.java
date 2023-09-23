package com.booleanuk.core.Accounts;

import com.booleanuk.core.Enums.Branches;
import com.booleanuk.core.Users.User;

import java.math.BigDecimal;

public class SavingsAccount extends Account{
    public SavingsAccount(BigDecimal balance, Branches branch, User accountHolder) {
        super(balance, branch, accountHolder);
    }
}
