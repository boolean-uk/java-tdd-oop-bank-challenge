package com.booleanuk.extension;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SavingAccountTest {
    @Test
    public void testCreateAccountWithBranch(){
        SavingAccount account = new SavingAccount(0, new Branch("123","Somewhere"));
        Assertions.assertEquals("123",account.getBranch().getCode());
        Assertions.assertEquals("Somewhere",account.getBranch().getAddress());

    }
}
