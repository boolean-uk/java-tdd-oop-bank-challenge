package com.booleanuk.core;

import com.booleanuk.core.enums.Branch;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountTest {

    @Test
    public void testCreatingAccountAndDeposit(){
        Account account = new SavingsAccount(1, "John", Branch.ABC, new TransactionManager());
        Assertions.assertTrue(account.deposit(1000));

    }
    @Test
    public void testWithdrawingFromAccountWithInsufficientFunds(){
        Account account = new SavingsAccount(1, "John", Branch.ABC, new TransactionManager());
        Assertions.assertFalse(account.withdraw(200));
    }

    @Test
    public void testWithdrawingFromAccountWithSufficientFunds(){
        Account account = new SavingsAccount(1, "John", Branch.ABC, new TransactionManager());
        account.deposit(1000);
        Assertions.assertTrue(account.withdraw(200));
    }
}
