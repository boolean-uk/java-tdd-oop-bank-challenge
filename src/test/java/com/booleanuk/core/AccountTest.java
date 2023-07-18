package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountTest {

    Account myAccount = new Account();

    @Test
    public void testAccount() {
        Assertions.assertNotNull(myAccount);
    }

    @Test
    public void testAccountNumber() {

        myAccount.setAccountNumber(123456789);

        Assertions.assertEquals(123456789, myAccount.getAccountNumber());
    }

}
