package com.booleanuk.core;

import java.io.Serializable;
import java.util.ArrayList;

public class CurrentAccount extends Account implements Serializable {


    public CurrentAccount(int id, String accountHolder){
        super(id, accountHolder);
    }
    public CurrentAccount(int id, String accountHolder, Branch branch){
        super(id, accountHolder, branch);
    }

    @Override
    public boolean withdraw(double amount) {
        if(amount > balance && overdraftApproved){
            balance -= amount;
            bankStatements.add(new BankStatement(balance, amount, Type.WITHDRAW));
            return true;

        }
        else if(amount > balance && !overdraftApproved){
            return false;
        }
        else{
            balance -= amount;
            bankStatements.add(new BankStatement(balance, amount, Type.WITHDRAW));
            return true;
        }
    }
}
