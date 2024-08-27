package com.booleanuk.core;

import org.junit.jupiter.api.Test;

public class AccountTest {
    @Test
    public void testDepositFunds(){
        Account account = new Account();
        account.depositFunds(5.00);


    }
}
