package com.booleanuk.core;

import org.junit.jupiter.api.Test;

public class CurrentAccountTest {

    @Test
    public void createACurrentAccount() {
        int accountId = 123;
        CurrentAccount currentAccount = new CurrentAccount(accountId);
    }
}
