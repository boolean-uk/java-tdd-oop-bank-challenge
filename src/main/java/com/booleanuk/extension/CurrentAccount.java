package com.booleanuk.extension;

public class CurrentAccount extends Account {

   private double overdraftLimit;
   private OverdraftRequest overdraftRequest;

   public CurrentAccount(){
       this.overdraftLimit = setOverdraftLimit(1000);
   }

    public double setOverdraftLimit(double overdraftLimit){
         return overdraftLimit;
    }

    public double getOverdraftLimit(){
        return overdraftLimit;
    }

    public void setOverdraftRequest(OverdraftRequest overdraftRequest) {
        this.overdraftRequest = overdraftRequest;
    }

    public OverdraftRequest getOverdraftRequest() {
        return overdraftRequest;
    }
}
