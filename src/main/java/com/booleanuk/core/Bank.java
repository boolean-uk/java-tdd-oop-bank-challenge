package com.booleanuk.core;
import com.booleanuk.core.enums.BANK_NAMES;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private final BANK_NAMES bankName;
    private final List<Branch> branches =new ArrayList<>();
    private final BankManager bankManager;

    public Bank(BANK_NAMES bankName, BankManager bankManager) {
        this.bankName = bankName;
        this.bankManager = bankManager;
    }

    public void addBranch(Branch branch){
        this.branches.add(branch);
    }

}
