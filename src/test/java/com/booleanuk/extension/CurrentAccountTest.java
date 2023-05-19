package com.booleanuk.extension;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CurrentAccountTest {
    @Test
    public void testCreateAccountWithBranch(){
        CurrentAccount account = new CurrentAccount(0, new Branch("123","Somewhere"));
        Assertions.assertEquals("123",account.getBranch().getCode());
        Assertions.assertEquals("Somewhere",account.getBranch().getAddress());

    }
}
