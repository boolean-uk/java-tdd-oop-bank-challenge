package com.booleanuk.core;

import com.booleanuk.core.enums.Branch;
import com.booleanuk.core.enums.Type;

import java.io.Serializable;

public class CurrentAccount extends Account implements Serializable {


    public CurrentAccount(int id, String accountHolder, Branch branch, TransactionManager transactionManager){
        super(id, accountHolder, branch, transactionManager);
    }

    @Override
    public boolean withdraw(double amount) {
        if(amount > transactionManager.getBalance(this.id) && overdraftApproved){
            transactionManager.addTransaction(new Transaction(this.id, -amount));
            bankStatements.add(new BankStatement(transactionManager.getBalance(this.id), amount, Type.WITHDRAW));
            return true;

        }
        else if(amount > transactionManager.getBalance(this.id) && !overdraftApproved){
            return false;
        }
        else{
            transactionManager.addTransaction(new Transaction(this.id, -amount));
            bankStatements.add(new BankStatement(transactionManager.getBalance(this.id), amount, Type.WITHDRAW));
            return true;
        }
    }
}
