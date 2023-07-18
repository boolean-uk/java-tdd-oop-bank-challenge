package com.booleanuk.core;

import com.booleanuk.core.extension.BankBranch;

public class CurrentAccount extends Account {
    public CurrentAccount(BankBranch bankBranch) {
        this.bankBranch = bankBranch;
        this.name = "Current";
        this.accountNumber = String.valueOf(100000000 + random.nextInt(900000000));
    }
}
