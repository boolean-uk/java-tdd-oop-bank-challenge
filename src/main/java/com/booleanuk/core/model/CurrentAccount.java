package com.booleanuk.core.model;

import com.booleanuk.core.model.enumerations.OVERDRAFT_STATE;
import com.booleanuk.core.model.enumerations.TRANSACTION_TYPE;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class CurrentAccount extends Account {
    private List<OverdraftRequest> overdraftRequests;

    CurrentAccount(BigDecimal amount, Customer customer) {
        super(amount, customer);
        this.overdraftRequests = new ArrayList<>();
    }

    public void requestOverdraft(BigDecimal amount) {
        overdraftRequests.add(new OverdraftRequest(amount, this));
    }

    public void overdraft(OverdraftRequest request) {
        if (request == null)
            throw new NullPointerException("Overdraft request must be non-null.");
        if (request.getState() == OVERDRAFT_STATE.APPROVED) {
            request.getAccount().createTransaction(request.getAmount(), TRANSACTION_TYPE.WITHDRAWAL);
            System.out.println("Overdraft request has been completed.");
        }
        else if (request.getState() == OVERDRAFT_STATE.DENIED)
            System.out.println("Request has not been approved.");
        else
            System.out.println("Request has not been processed yet.");
    }

    public List<OverdraftRequest> getOverdraftRequests() {
        return overdraftRequests;
    }
}
