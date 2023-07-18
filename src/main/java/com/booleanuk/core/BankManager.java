package com.booleanuk.core;

import com.booleanuk.core.enums.OVERDRAFT_STATE;

public class BankManager {
    private final String name;
    private final String surname;

    public BankManager(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public void processOverdraftRequest(OverdraftRequest request, OVERDRAFT_STATE state){
        request.setRequestState(state);
    }

}
