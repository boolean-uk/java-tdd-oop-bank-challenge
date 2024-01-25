package com.booleanuk.core;

import org.junit.jupiter.api.Test;

public class CurrentAccountTest {

    @Test
    public void initCurrentAccount() {
        Account currentAccount = new CurrentAccount("AccountName", Branches.Oslo);
    }

}
