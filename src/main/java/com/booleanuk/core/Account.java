package com.booleanuk.core;

import java.math.BigDecimal;

public class Account {
    BigDecimal amount;
    String branchID;

    public Account(BigDecimal amount,String branchID) {
        this.amount = amount;
        this.branchID=branchID;
    }

    void deposit(BigDecimal deposit){
        this.amount=amount.add(deposit);
    }
    void withdraw(BigDecimal withdraw){
        var newAmount=amount.subtract(withdraw);
        if(newAmount.compareTo(BigDecimal.ZERO)>0){
        this.amount=newAmount;
        }else{
            throw new IllegalArgumentException();
        }
    }

}
