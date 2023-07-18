package com.booleanuk.core;

public class Manager {
    private String fullName;

    public Manager(String fullName) {
        this.fullName = fullName;
    }

    public boolean ApproveOverdraftRequest(NormalAccount normalAccount, double amount)
    {
        if(normalAccount.getBalance()+normalAccount.getDebit()>=amount)
        {
            return  true;
        }
        return false;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
