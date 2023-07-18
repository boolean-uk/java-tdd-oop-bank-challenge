package com.booleanuk.core;
import com.booleanuk.core.enums.BANK_NAMES;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private final BANK_NAMES bankName;
    private final List<Branch> branches =new ArrayList<>();

    public Bank(BANK_NAMES bankName) {
        this.bankName = bankName;
    }

    public void addBranch(Branch branch){
        this.branches.add(branch);
    }

}
