package com.booleanuk.core;

import java.io.Serializable;
import java.util.ArrayList;

public class SavingsAccount extends Account implements Serializable {

    public SavingsAccount(int id, String accountHolder){
        super(id, accountHolder);
    }
    public SavingsAccount(int id, String accountHolder, Branch branch){
        super(id, accountHolder, branch);
    }

}
