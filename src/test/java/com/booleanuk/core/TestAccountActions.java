package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestAccountActions {
    @Test
    public void testCreateAccount() {
        AccountActions accountAction = new AccountActions();

        //Test for successful creation of current account
        Assertions.assertTrue(accountAction.createAccount("Current","NDBK-0000-0001", "Aidan", "van Geest", "ROT001"));

        //Test for successful creation of savings account
        Assertions.assertTrue(accountAction.createAccount("Savings","NDBK-0000-0002", "Aidan", "van Geest", "ROT001"));

        //Test for failed creation of account due to invalid account number
        Assertions.assertFalse(accountAction.createAccount("Current","NDBK-0000-0001", "Aidan", "van Geest", "ROT001"));

        //Test for failed creation of account due to invalid account type
        Assertions.assertFalse(accountAction.createAccount("Investment","NDBK-0000-0003", "Aidan", "van Geest", "ROT001"));
    }

    @Test
    public void testSearchAccount() {
        AccountActions accountAction = new AccountActions();
        accountAction.createAccount("Current","NDBK-0000-0001", "Aidan", "van Geest", "ROT001");

        //Test for existing account
        Assertions.assertEquals(accountAction.accounts.get(0), accountAction.searchAccount("NDBK-0000-0001"));

        //Test for account that does not exist
        Assertions.assertNull(accountAction.searchAccount("ABCD"));
    }

    @Test
    public void testDeposit() {
        AccountActions accountAction = new AccountActions();
        accountAction.createAccount("Current","NDBK-0000-0001", "Aidan", "van Geest", "ROT001");

        //Test for successful deposits
        Assertions.assertTrue(accountAction.deposit("NDBK-0000-0001", 200.50));
        Assertions.assertTrue(accountAction.deposit("NDBK-0000-0001", 100.25));

        Assertions.assertEquals(300.75, accountAction.accounts.get(0).getBalanceInDollars());

        //Test for failed deposit
        Assertions.assertFalse(accountAction.deposit("ABCD", 200.50));
    }

    @Test
    public void testWithdraw() {
        AccountActions accountAction = new AccountActions();
        accountAction.createAccount("Current","NDBK-0000-0001", "Aidan", "van Geest", "ROT001");
        accountAction.deposit("NDBK-0000-0001", 200.50);

        //Test for successful withdrawals
        Assertions.assertTrue(accountAction.withdraw("NDBK-0000-0001", 50));
        Assertions.assertTrue(accountAction.withdraw("NDBK-0000-0001", 10.25));

        Assertions.assertEquals(140.25, accountAction.accounts.get(0).getBalanceInDollars());

        //Test for failed withdrawal (Account doesn't exist)
        Assertions.assertFalse(accountAction.withdraw("ABCD", 200.50));

        //Test for failed withdrawal (Balance will become negative)
        Assertions.assertFalse(accountAction.withdraw("NDBK-0000-0001", 300));
    }



}
