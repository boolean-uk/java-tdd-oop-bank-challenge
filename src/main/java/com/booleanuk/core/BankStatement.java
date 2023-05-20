package com.booleanuk.core;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

public class BankStatement {

    private Account account;

    public BankStatement(Account account) {
        this.account = account;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }


}
