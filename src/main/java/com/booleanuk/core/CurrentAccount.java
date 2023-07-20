package com.booleanuk.core;

import java.math.BigDecimal;

public class CurrentAccount extends Account{
    public final static BigDecimal overdraftLimit=BigDecimal.valueOf(-400);
    boolean acceptOverdraft=false;
    public void giveAcceptanceForOverdraft(){
        this.acceptOverdraft=true;
    }
    public void denyOverdraft(){
        this.acceptOverdraft=false;
    }
    public CurrentAccount(BigDecimal amount,String branchID) {
        super(amount,branchID);
    }
    @Override
    void withdraw(BigDecimal withdraw) {
        var newAmount = amount.subtract(withdraw);
        if( newAmount.compareTo(BigDecimal.ZERO) > 0){
            this.amount = newAmount;

        } else if(acceptOverdraft&&newAmount.compareTo(overdraftLimit)>0){
                this.amount = newAmount;
        } else{
            throw new IllegalArgumentException();
        }
    }
}
