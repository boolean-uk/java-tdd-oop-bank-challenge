package com.booleanuk.extension;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.booleanuk.core.CurrentAccount;

public class TwilioTester {

    CurrentAccount myAccount = new CurrentAccount("C123456789", 0);

    @Test
    public void testTwilioService() {

        myAccount.setBalance(0);

        myAccount.deposit(1000);

        myAccount.withdraw(390);

        myAccount.setOverdraftLimit(1000);

        myAccount.withdraw(1000);

        myAccount.deposit(780);

        myAccount.deposit(200);

        TwilioService.sendSmsMessage("+48721917084", myAccount.getStatement().generateStatement());

        Assertions.assertTrue(true);
    }

}
