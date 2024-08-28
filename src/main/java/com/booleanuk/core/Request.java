package com.booleanuk.core;

import com.booleanuk.core.accounts.Account;
import com.booleanuk.core.idgenerator.IdGenerator;
import com.booleanuk.core.idgenerator.IdPrefix;

public class Request {

    private final String id;
    private final Account account;
    private Double overdraftSum;

    public Request(Account account, Double overdraftSum) {
        this.id = new IdGenerator(IdPrefix.RE).getId();
        this.account = account;
        this.overdraftSum = overdraftSum;
    }

    public String getId() {
        return id;
    }

    // TODO: If time, add some function so the user can
    //  validate if it's an reasonable amount of overdraft
    //  with the overdraft sum

    public void approve() {
        this.account.setPossibleToOverdraft(true);
    }

    public void reject() {
        this.account.setPossibleToOverdraft(false);
    }
}
