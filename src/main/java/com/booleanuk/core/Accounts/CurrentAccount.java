package com.booleanuk.core.Accounts;

import com.booleanuk.core.Bank.Branch;
import com.booleanuk.core.Enums.Branches;
import com.booleanuk.core.Enums.Status;
import com.booleanuk.core.Users.User;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
@Getter
@Setter
public class CurrentAccount extends Account {
    private Status overdraftStatus;
    private BigDecimal overdraftLimit;


    public CurrentAccount(BigDecimal initialBalance, Branch branch, User accountHolder) {
        super(initialBalance, branch, accountHolder);
        this.overdraftLimit = BigDecimal.ZERO;
        this.overdraftStatus = Status.None;
    }

    @Override
    public boolean requestOverdraft(BigDecimal amount) {
        if (this.overdraftStatus.equals(Status.Rejected)) {
            this.overdraftStatus = Status.None;
            this.overdraftLimit = BigDecimal.ZERO;
        }
        if (amount.compareTo(BigDecimal.ZERO) > 0) {
            overdraftLimit = amount;
            overdraftStatus = Status.Pending;
            return true;
        } else {
            throw new IllegalArgumentException("The requested amount must be a positive number!");
        }
    }

}
