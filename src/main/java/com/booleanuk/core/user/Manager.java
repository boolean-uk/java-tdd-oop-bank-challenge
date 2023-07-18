package com.booleanuk.core.user;

import com.booleanuk.core.banking.BankBranch;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Manager extends User {
    private BankBranch bankBranch;

    public Manager(BankBranch bankBranch) {
        super();
        this.bankBranch = bankBranch;
    }
}
