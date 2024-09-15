package com.booleanuk.core;

import com.booleanuk.core.enums.Branch;

import java.io.Serializable;

public class SavingsAccount extends Account implements Serializable {

    public SavingsAccount(int id, String accountHolder, Branch branch, TransactionManager transactionManager){
        super(id, accountHolder, branch, transactionManager);
    }

}
