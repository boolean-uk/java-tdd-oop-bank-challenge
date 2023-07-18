package com.booleanuk.core;

public class CurrentAccount extends Account{
    private String typeOfAccount;
    public CurrentAccount() {
        this.typeOfAccount = "current";
    }

    public String getTypeOfAccount() {
        return typeOfAccount;
    }
}
