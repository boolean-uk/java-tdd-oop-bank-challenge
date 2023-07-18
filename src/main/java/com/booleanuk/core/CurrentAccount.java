package com.booleanuk.core;

import java.math.BigDecimal;

public class CurrentAccount extends BankAccount{
    private Overdraft overdraft;

    public CurrentAccount(String accountNumber, Branch branch) {
        super(accountNumber,branch);
        overdraft = new Overdraft();
    }

    public void withdraw(BigDecimal amount, String date, String type) {
        if(getBalance().subtract(amount).compareTo(BigDecimal.ZERO)<0){
            if(overdraft.getStatus().equals("approved")){
                if(getBalance().subtract(amount).abs().compareTo(overdraft.getLimit()) > 0) System.out.println("overdraft limit reached");
                else super.withdraw(amount,date,"Overdraft Withdrawal");
            }else System.out.println("overdraft not approved");
        }else super.withdraw(amount,date,type);
    }
    public void requestOverdraft(BigDecimal limit){
        this.overdraft.setStatus("pending");
        this.overdraft.setLimit(limit);

    }

    public Overdraft getOverdraft() {
        return overdraft;
    }

}
