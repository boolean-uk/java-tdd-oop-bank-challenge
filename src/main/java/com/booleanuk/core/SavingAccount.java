package com.booleanuk.core;

import com.booleanuk.core.extension.BankBranch;

public class SavingAccount extends Account {
    public SavingAccount(BankBranch bankBranch) {
        this.name = "Saving";
        this.accountNumber = String.valueOf(100000000 + random.nextInt(900000000));
        this.bankBranch = bankBranch;
    }
}
