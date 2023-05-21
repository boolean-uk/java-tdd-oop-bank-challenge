package com.booleanuk.core.model;

import com.booleanuk.core.model.enumerations.OVERDRAFT_STATE;

public class BankManager {
    public void processOverdraftRequest(OverdraftRequest request, OVERDRAFT_STATE state) {
        if (request == null || state == null)
            throw new NullPointerException("Overdraft request and state can't be null.");

        request.setState(state);
    }
}
