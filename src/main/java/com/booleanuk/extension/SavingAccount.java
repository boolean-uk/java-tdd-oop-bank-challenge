package com.booleanuk.extension;

public class SavingAccount extends Account {

    private String typeOfAccount;
    public SavingAccount() {
        this.typeOfAccount = "saving";
    }

    public String getTypeOfAccount() {
        return typeOfAccount;
    }
}
