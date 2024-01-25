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
        CurrentAccount ca = new CurrentAccount();
        SavingsAccount sa = new SavingsAccount();

        int caid = ca.getAccountID();
        int said = sa.getAccountID();

        Assertions.assertTrue(user1.newAccount(ca));
        Assertions.assertTrue(user1.newAccount(sa));

        user1.showAccounts();

        Assertions.assertEquals(0, user1.getAccount(caid).getBalance());
        Assertions.assertEquals(0, user1.getAccount(said).getBalance());

        User user2 = new User("Darth", "Vader");

        Assertions.assertFalse(user2.newAccount(ca));
        user2.showAccounts();
    }

    @Test
    public void testWithdraw(){
        User user = new User("Kevin", "James");
        CurrentAccount ca = new CurrentAccount();
        user.newAccount(ca);
        int caid = ca.getAccountID();

        Assertions.assertFalse(user.withdraw(caid, 2300));
        Assertions.assertEquals(0, user.getAccount(caid).getBalance());
        Assertions.assertFalse(user.withdraw(caid, 500));
        Assertions.assertEquals(0, user.getAccount(caid).getBalance());
        Assertions.assertFalse(user.withdraw(caid, -100));
    }

    @Test
    public void testDeposit(){
        User user = new User("Adam", "Sandler");
        SavingsAccount sa = new SavingsAccount();
        user.newAccount(sa);
        int said = sa.getAccountID();

        Assertions.assertTrue(user.deposit(said, 2300));
        Assertions.assertEquals(2300, user.getAccount(said).getBalance());
        Assertions.assertTrue(user.deposit(said, 500));
        Assertions.assertEquals(2800, user.getAccount(said).getBalance());
        Assertions.assertFalse(user.deposit(said, -101));
        Assertions.assertEquals(2800, user.getAccount(said).getBalance());
    }

    @Test
    public void testWithdrawAndDeposit(){
        User user = new User("Jack", "Black");
        SavingsAccount sa = new SavingsAccount();
        user.newAccount(sa);
        int said = sa.getAccountID();

        Assertions.assertFalse(user.withdraw(said, 100));
        Assertions.assertTrue(user.deposit(said, 10000));
        Assertions.assertEquals(10000, user.getAccount(said).getBalance());
        Assertions.assertTrue(user.withdraw(said, 1000));
        Assertions.assertEquals(9000, user.getAccount(said).getBalance());
        Assertions.assertTrue(user.withdraw(said, 5000));
        Assertions.assertEquals(4000, user.getAccount(said).getBalance());
        Assertions.assertFalse(user.withdraw(said, 4001));
        Assertions.assertTrue(user.deposit(said, 1));
        Assertions.assertTrue(user.withdraw(said, 4001));
    }

    @Test
    public void testOverdraft(){
        User user = new User("Diane", "Lane");
        CurrentAccount ca = new CurrentAccount();
        user.newAccount(ca);
        int caid = ca.getAccountID();

        Assertions.assertTrue(user.requestOverdraft(caid, 500));
        System.out.println(user.getAccount(caid).getBalance());
        Assertions.assertTrue(user.withdraw(caid, 300));
        Assertions.assertFalse(user.withdraw(caid, 201));
        Assertions.assertFalse(user.requestOverdraft(caid, 100000));
    }

    @Test
    public void testOverdraftWithSavingsAccount(){
        User user = new User("Ninjago", "Warrior");
        SavingsAccount sa = new SavingsAccount();
        user.newAccount(sa);
        int said = sa.getAccountID();

        Assertions.assertFalse(user.requestOverdraft(said, 400));
    }

    @Test
    public void testMethodsWithoutCreatingAccountFirst(){
        User user = new User("Shrek", "Fiona");

        Assertions.assertNull(user.getAccount(1));
        Assertions.assertFalse(user.withdraw(2, 500));
        Assertions.assertFalse(user.requestOverdraft(4, 200));
    }
}


