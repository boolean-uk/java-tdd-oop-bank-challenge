package com.booleanuk.core;

import org.junit.jupiter.api.Test;

public class AccountTest {
    @Test
    public void testDepositFunds(){
        Account account = new Account(15.00);
        account.depositFunds(5.00);
        System.out.println(account.transactions.get(0).getTransactionAmount());

    }
}
