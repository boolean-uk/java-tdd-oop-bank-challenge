package com.booleanuk.core;

import com.booleanuk.core.enums.Branch;

import java.io.Serializable;

public class SavingsAccount extends Account implements Serializable {

    public SavingsAccount(int id, String accountHolder){
        super(id, accountHolder);
    }
    public SavingsAccount(int id, String accountHolder, Branch branch){
        super(id, accountHolder, branch);
    }

}
