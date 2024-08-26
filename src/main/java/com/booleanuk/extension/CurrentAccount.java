package com.booleanuk.extension;

public class CurrentAccount extends Account {

   private double overdraftLimit;
   private OverdraftRequest overdraftRequest;

   public CurrentAccount(){
       setOverdraftLimit(1000);
   }

    public void setOverdraftLimit(double overdraftLimit){
         this.overdraftLimit = overdraftLimit;
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
