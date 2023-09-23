package com.booleanuk.core.Accounts;

import com.booleanuk.core.Enums.Branches;
import com.booleanuk.core.Users.User;

import java.math.BigDecimal;

public class SavingsAccount extends Account{
    private final BigDecimal interestRate = BigDecimal.valueOf(3.01);
    public SavingsAccount(BigDecimal balance, Branches branch, User accountHolder) {
        super(balance, branch, accountHolder);
    }
    @Override
    public boolean requestOverdraft() {
        System.out.println("You cannot request an overdraft on your savings account!");
        return false;
    }
}
