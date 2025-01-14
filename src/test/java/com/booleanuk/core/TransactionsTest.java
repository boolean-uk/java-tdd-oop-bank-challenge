package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TransactionsTest {

    @Test
    public void depositToAccount() {
        CurrentAccount currentAccount = new CurrentAccount(500);
        Transactions transactions = new Transactions();

        transactions.deposit(currentAccount,200);

        Assertions.assertEquals(700, currentAccount.getBalance());

    }
}
