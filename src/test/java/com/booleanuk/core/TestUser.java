package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestUser{
    @Test
    public void testID(){
        User user1 = new User("Jacob", "Jacobsson");
        User user2 = new User("Eli", "Elisson");

        Assertions.assertNotEquals(user1.getUserID(), user2.getUserID());
    }

    @Test
    public void testNewAccount(){
        User user1 = new User("Han", "Solo");
        CurrentAccount currentAccount = new CurrentAccount();

        Assertions.assertTrue(user1.newAccount(currentAccount));
        Assertions.assertTrue(user1.newAccount(new SavingsAccount()));

        user1.showAccounts();

        Assertions.assertEquals(0, user1.getAccount(1).getBalance());
        Assertions.assertEquals(0, user1.getAccount(2).getBalance());

        User user2 = new User("Darth", "Vader");

        Assertions.assertFalse(user2.newAccount(currentAccount));
        user2.showAccounts();
    }

    @Test
    public void testWithdraw(){
        User user = new User("Kevin", "James");
        user.newAccount(new CurrentAccount());
        user.withdraw(1, 2300);

        Assertions.assertEquals(0, user.getAccount(1).getBalance());

        user.withdraw(1, 500);

        Assertions.assertEquals(0, user.getAccount(1).getBalance());
    }

    @Test
    public void testDeposit(){

    }
/*
    @Test
    public void testWithdrawAndDeposit(){

    }

    @Test
    public void testOverdraft(){

    }

    @Test
    public void testMethodsWithoutCreatingAccountFirst(){

    }

 */
}


