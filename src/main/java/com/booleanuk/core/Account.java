package com.booleanuk.core;

import java.math.BigDecimal;

public class Account {
    BigDecimal amount;

    public Account(BigDecimal amount) {
        this.amount = amount;
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
