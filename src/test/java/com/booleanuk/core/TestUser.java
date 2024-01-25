package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestUser{
    @Test
    public void testID(){
        User user1 = new User("Jacob", "Jacobsson"); // User 1
        User user2 = new User("Eli", "Elisson"); // User 2

        Assertions.assertNotEquals(user1.getUserID(), user2.getUserID());
    }

    @Test
    public void testNewAccount(){
        User user1 = new User("Han", "Solo"); // User 3
        CurrentAccount currentAccount = new CurrentAccount(); // Account 1

        Assertions.assertTrue(user1.newAccount(currentAccount));
        Assertions.assertTrue(user1.newAccount(new SavingsAccount())); // Account 2

        user1.showAccounts();

        Assertions.assertEquals(0, user1.getAccount(1).getBalance());
        Assertions.assertEquals(0, user1.getAccount(2).getBalance());

        User user2 = new User("Darth", "Vader"); // User 4

        Assertions.assertFalse(user2.newAccount(currentAccount));
        user2.showAccounts();
    }

    @Test
    public void testWithdraw(){
        User user = new User("Kevin", "James"); // User 5
        user.newAccount(new CurrentAccount()); // Account 3

        Assertions.assertFalse(user.withdraw(3, 2300));
        Assertions.assertEquals(0, user.getAccount(3).getBalance());
        Assertions.assertFalse(user.withdraw(3, 500));
        Assertions.assertEquals(0, user.getAccount(3).getBalance());
    }

    @Test
    public void testDeposit(){
        User user = new User("Adam", "Sandler"); //User 6
        user.newAccount(new CurrentAccount()); // Account 4
        user.deposit(4, 2300);

        Assertions.assertEquals(2300, user.getAccount(4).getBalance());

        user.deposit(4, 500);

        Assertions.assertEquals(2800, user.getAccount(4).getBalance());
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


