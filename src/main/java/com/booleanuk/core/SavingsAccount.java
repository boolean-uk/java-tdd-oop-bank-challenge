package com.booleanuk.core;

import java.util.ArrayList;

public class SavingsAccount extends Account{

    public SavingsAccount(int id, String accountHolder){
        super(id, accountHolder);
        bankStatements = new ArrayList<>();
    }

}
