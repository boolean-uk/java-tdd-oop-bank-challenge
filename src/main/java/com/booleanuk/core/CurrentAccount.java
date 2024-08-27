package com.booleanuk.core;

import static com.booleanuk.core.NumberUtils.*;

public class CurrentAccount extends Account{

    private Boolean canOverdraft;
    private Boolean overdraftRequestPending;



    public CurrentAccount(String name, Branch branch) {
        super(name, branch);
        this.canOverdraft = false;
        this.overdraftRequestPending = false;
    }

    public Boolean getOverdraftRequestPending() {
        return overdraftRequestPending;
    }

    public void setOverdraftRequestPending(Boolean overdraftRequestPending) {
        this.overdraftRequestPending = overdraftRequestPending;
    }

    public void setCanOverdraft(Boolean canOverdraft) {
        this.canOverdraft = canOverdraft;
    }
    public void requestOverdraft(){
        this.overdraftRequestPending = true;
    }

    @Override
    public String withdraw(float amountInPounds){
        if (amountInPounds > centsToPounds(getBalanceInCents()) && !canOverdraft){
            return "Not enough funds.";
        }

        super.withdraw(amountInPounds);
        return "Funds withdrawn from account.";
    }
}
