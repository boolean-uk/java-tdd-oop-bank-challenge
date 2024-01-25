package com.booleanuk.core;

import java.util.ArrayList;

public class CurrentAccount extends Account{


    public CurrentAccount(int id, String accountHolder){
        super(id, accountHolder);
    }
    public CurrentAccount(int id, String accountHolder, Branch branch){
        super(id, accountHolder, branch);
        bankStatements = new ArrayList<>();
    }

}
