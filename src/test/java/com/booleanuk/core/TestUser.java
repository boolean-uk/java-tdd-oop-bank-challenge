package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestUser{
    @Test
    public void testID(){
        User user1 = new User("Jacob", "Jacobsson");
        User user2 = new User("Eli", "Elisson");

        Assertions.assertNotEquals(user1.getID(), user2.getID());
    }

    @Test
    public void testNewAccount(){
        User user = new User("Han", "Solo");
        user.newAccount(new CurrentAccount());
        user.newAccount(new SavingsAccount());
        user.accounts();

        Assertions.assertEquals(0, user.getAccount(1).getBalance());
        Assertions.assertEquals(0, user.getAccount(2).getBalance());
    }

    @Test
    public void testWithdraw(){
        User user = new User("Kevin", "James");
        user.newAccount(new CurrentAccount());
        user.deposit(1, 2300);

        Assertions.assertEquals(2300, user.getAccount(1).getBalance());

        user.deposit(1, 500);

        Assertions.assertEquals(2800, user.getAccount(1).getBalance());
    }

    @Test
    public void testDeposit(){

    }

    @Test
    public void testWithdrawAndDeposit(){

    }

    @Test
    public void testOverdraft(){

    }

    @Test
    public void testMethodsWithoutCreatingAccountFirst(){

    }
}
