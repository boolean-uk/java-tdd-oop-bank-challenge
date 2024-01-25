package com.booleanuk.core;

import java.util.ArrayList;

public class SavingsAccount extends Account{

    public SavingsAccount(int id, String accountHolder){
        super(id, accountHolder);
    }
    public SavingsAccount(int id, String accountHolder, Branch branch){
        super(id, accountHolder, branch);
        bankStatements = new ArrayList<>();
    }

}
