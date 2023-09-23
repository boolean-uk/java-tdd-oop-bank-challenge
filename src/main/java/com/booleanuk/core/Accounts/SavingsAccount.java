package com.booleanuk.core.Accounts;

import com.booleanuk.core.Enums.Branches;
import com.booleanuk.core.Users.User;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
public class SavingsAccount extends Account{
    private final BigDecimal interestRate = BigDecimal.valueOf(3.01);
    private final BigDecimal initialDepositMinimum = BigDecimal.valueOf(1500);
    public SavingsAccount(BigDecimal balance, Branches branch, User accountHolder) {

        super(balance, branch, accountHolder);
        if (balance.compareTo(this.initialDepositMinimum) < 0) {
            throw new IllegalArgumentException("Savings account must be opened with a minimum deposit of " + initialDepositMinimum);
        }
    }
    @Override
    public boolean requestOverdraft(BigDecimal amount) {
        System.out.println("You cannot request an overdraft on your savings account!");
        return false;
    }
//    @Override
//    public void setBalance(BigDecimal balance) {
//        if (balance.compareTo(this.getInitialDepositMinimum()) < 0) {
//            throw new IllegalArgumentException("Balance cannot be set below the minimum deposit of " + initialDepositMinimum);
//        }
//        super.setBalance(balance);
//    }
}
