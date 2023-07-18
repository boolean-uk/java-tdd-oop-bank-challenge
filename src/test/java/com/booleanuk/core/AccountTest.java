package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountTest {

    Account myAccount = new Account();

    @Test
    public void testAccount() {
        Assertions.assertNotNull(myAccount);
    }

}
