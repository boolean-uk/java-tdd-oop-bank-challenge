package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SavingsAccountTest {

    @Test
    public void SavingsAccountDepositTest(){

        AccountOwner me = new AccountOwner("PS1234", "Benjamin Cool");
        SavingsAccount savingsAccount = new SavingsAccount(me);

        //Should give correct return message and increase the arraylist where the transactions are stored by one.
        Assertions.assertEquals("1000.0£ deposited", savingsAccount.deposit(1000));
        Assertions.assertEquals(1, savingsAccount.getBankStatement().size());

        Assertions.assertEquals("2000.0£ deposited", savingsAccount.deposit(2000));
        Assertions.assertEquals(2, savingsAccount.getBankStatement().size());

    }


}
