package com.booleanuk.core;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;

public class SavingsAccount extends  BankAccount {
    private BigDecimal interestRate;
    public SavingsAccount(String accountNumber, Branch branch, BigDecimal interestRate) {
        super(accountNumber, branch);
        this.interestRate = interestRate;
    }


    public void withdraw(BigDecimal amount, String date, String type) {
        if(getBalance().subtract(amount).compareTo(BigDecimal.ZERO)<0){
            System.out.println("Insufficient balance");
        }
        else{
            super.withdraw(amount, date, type);
        }
    }
}
