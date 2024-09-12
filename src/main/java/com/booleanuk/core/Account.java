package com.booleanuk.core;

public interface Account {




    public String getAccountNumber();

    public void setAccountNumber(String accountNumber);

    public double getBalance();

    public void setBalance(double balance);

    public void setOverDraftTrue();


    public void setOverDraftFalse();

    public boolean isOverDraft();
    public String getName();
    public void setName(String name);

}
